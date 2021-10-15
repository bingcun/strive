package ai.yuhan.demo.service.police;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/9/20 11:29
 * @Version 1.0
 */
@Component
public class JZQSignHandler implements AbstractSignHandler{
    @Override
    public String route() {
        return "jzq";
    }

    @Override
    public void methodOne() {
        System.out.println("在这里调用jzq方法A");
    }

    @Override
    public void methodTwo() {
        System.out.println("在这里调用jzq方法B");
    }
}
