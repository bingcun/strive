package ai.yuhan.demo.base.service.impl;

import ai.yuhan.demo.base.entity.TB_USER;
import ai.yuhan.demo.base.mapper.TransactionMapper;
import ai.yuhan.demo.base.service.BeanPostProcessorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/22 9:52
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Service
public class BeanPostProcessorServiceImpl implements BeanPostProcessorService {

    @Resource
    private TransactionMapper transactionMapper;

    @Transactional
    @Override
    public void sayHello() {
        //插入
        transactionMapper.insert(TB_USER.builder().username("chenbingcun").email("820306546@qq.com").created(new Date()).phone("18045074771").updated(new Date()).build());


    }

    @Override
    public String getTransaction() {
        //插入
        transactionMapper.insert(TB_USER.builder().username("chenbingcun").password("123456").email("820306546@qq.com").created(new Date()).phone("18045074771").updated(new Date()).build());
        System.out.println(1/0);
        List<String> list = new Vector<String>();
        list.add("123");
        list.add("456");
        list.add("789");


        return "ok";
    }
}
