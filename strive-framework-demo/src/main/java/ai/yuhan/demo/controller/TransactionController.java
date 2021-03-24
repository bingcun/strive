package ai.yuhan.demo.controller;

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

}
