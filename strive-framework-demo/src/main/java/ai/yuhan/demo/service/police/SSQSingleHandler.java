package ai.yuhan.demo.service.police;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/9/20 11:28
 * @Version 1.0
 */
@Component
public class SSQSingleHandler implements AbstractSignHandler{
    //路由
    @Override
    public String route() {
        return "ssq";
    }

    @Override
    public void methodOne() {
        System.out.println("在这里调用ssq方法A");
    }

    @Override
    public void methodTwo() {
        System.out.println("在这里调用ssq方法B");
    }
}
