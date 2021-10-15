package ai.yuhan.demo.controller;

import ai.yuhan.demo.service.police.EqbSignHandler;
import ai.yuhan.demo.service.police.MyHandlerDelegat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/9/20 11:23
 * @Version 1.0
 */
@RestController
public class TestPolicyModeController {

    @Autowired
    private MyHandlerDelegat myHandlerDelegat;

    @RequestMapping("/testPolicyMode")
    public String getString(){
        myHandlerDelegat.selectHandler("eqb").methodOne();
        return "ok";
    }
}
