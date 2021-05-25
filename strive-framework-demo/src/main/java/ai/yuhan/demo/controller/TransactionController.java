package ai.yuhan.demo.controller;

import ai.yuhan.demo.utils.hrstrix.hystrixCommand;
import ai.yuhan.demo.service.BeanPostProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/23 12:28
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@RestController
public class TransactionController {
    @Autowired
    private BeanPostProcessorService beanPostProcessorService;

    @GetMapping(value = "/getTransaction")
    public String getTransaction(){
        return beanPostProcessorService.getTransaction();
    }

    @GetMapping(value = "/testHystrix")
    @hystrixCommand(limit = 2,timeScope = 5)
    public String testHystrix(String name,String age){
        return "success";
    }

}
