package ai.yuhan.demo.controller;

import ai.yuhan.demo.conf.ThreadPoolManagerConfig;
import ai.yuhan.other.datastructure.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;
import java.util.UUID;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/8/17 13:38
 * @Version 1.0
 */
@RestController
public class ThreadController {

    @Autowired
    private ThreadPoolManagerConfig threadPoolManagerConfig;

    @GetMapping("/start/{id}")
    public String start(@PathVariable Long id){
        String orderNo = System.currentTimeMillis() + UUID.randomUUID().toString();
        threadPoolManagerConfig.addOrders(orderNo);
        return "Test ThreadPoolExecutor start";
    }

    @GetMapping(value = "/end/{id}")
    public String end(@PathVariable Long id){
        threadPoolManagerConfig.shutdown();

        Queue q = threadPoolManagerConfig.getMsgQueue();
        System.out.println("关闭了线程服务，还有未处理的信息条数："+q.size());
        return "Test ThreadPoolExecutor stop";
    }
}
