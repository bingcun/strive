package ai.yuhan.system.server.controller;

import ai.yuhan.core.api.CommonResult;
import ai.yuhan.system.server.service.AccountService;
import ai.yuhan.system.server.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/14 22:20
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@RestController
@RequestMapping("/system/user")
public class SystemController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private SystemService systemService;

    @PostMapping("/login")
    public CommonResult login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password,HttpServletRequest request){
        return accountService.login(username,password,request);
    }

    @GetMapping("/testTransactionInvalid")
    public String testTransactionInvalid(){
        return accountService.testTransactionInvalid();
    }

    @GetMapping("/testRabbitMq")
    public String testRabbitMq(){
        return systemService.testRabbitMq();
    }

}
