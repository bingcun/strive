package ai.yuhan.system.server.service.impl;

import ai.yuhan.core.api.CommonResult;
import ai.yuhan.core.util.WebUtils;
import ai.yuhan.core.vo.LoginInfo;
import ai.yuhan.system.server.entity.Permission;
import ai.yuhan.system.server.entity.Account;
import ai.yuhan.system.server.mapper.PermissionMapper;
import ai.yuhan.system.server.mapper.AccountMapper;
import ai.yuhan.system.server.service.AccountService;
import ai.yuhan.system.server.utils.JwtTokenUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/14 19:00
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private PermissionMapper permissionMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    public Account getByUsername(String username) {
        //根据用户名查询用户表
        return accountMapper.selectOne(Wrappers.<Account>lambdaQuery().eq(Account::getUsername, username));
    }

    @Override
    public CommonResult login(String username, String password, HttpServletRequest request) {

        UserDetails userDetails = this.loadUserByUsername(username);
        //密码需要客户端加密后传递
        if (!passwordEncoder.matches(password,userDetails.getPassword())) {
            throw new BadCredentialsException("密码不正确");
        }
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //生成token
        String token = jwtTokenUtil.generateToken(userDetails);

        //放入常用的数据到loginINfo
        LoginInfo loginInfo = this.initLoginInfo(username,request);
        WebUtils.setLoginInfoToRequest(request, loginInfo);

        //生成返回对象
        Map<String,Object> maps = new HashMap();
        maps.put("loginInfo",loginInfo);
        maps.put("token",token);
        return CommonResult.success(maps);
    }

    @Override
//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    //1.@Transaction修饰private修饰的类
    //2.设置propagation属性为不支持的事务
    //3.异常被try catch包围的块吃了
    @Transactional(rollbackFor = IOException.class)
    public String testTransactionInvalid() {
//        try {
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        this.invalid1();
        return "ok";
    }

    /**
     * 失效场景1:
     * @Transaction在private修饰的方法上面
     */
    private void invalid1(){
        Account account = Account.builder()
                .username("zhangsan1")
                .password("123456")
                .created(new Date())
                .updated(new Date())

                .build();
        accountMapper.insert(account);

        System.out.println(1/0);
    }



    //初始化LoginInfo信息
    private LoginInfo initLoginInfo(String Username,HttpServletRequest request) {
        //暂时缓存user和clientIp
        Map<String,Object> userMap = new HashMap<>();
        Account byUsername = this.getByUsername(Username);
        byUsername.setPassword(null);
        userMap.put("user",byUsername);
        return new LoginInfo(userMap,WebUtils.getClientIpFromRequest(request));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account tbUser = this.getByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (tbUser != null) {
            //根据用户id查询权限
            List<Permission> permissions = permissionMapper.selectByUserId(tbUser.getId());
            if (permissions.size() > 0 && permissions != null) {
                //设置权限
                permissions.forEach(permission -> {
                    if (permission != null && StringUtils.isEmpty(permission.getEnname())) {
                        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getEnname());
                        authorities.add(grantedAuthority);
                    }
                });
                return new org.springframework.security.core.userdetails.User(tbUser.getUsername(), tbUser.getPassword(),authorities);
            } else {
                throw new AuthenticationCredentialsNotFoundException("该用户没有设置权限");
            }
        } else {
             throw new UsernameNotFoundException("没有此用户");
        }
    }
}
