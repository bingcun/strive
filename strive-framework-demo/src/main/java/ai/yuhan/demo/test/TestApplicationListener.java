package ai.yuhan.demo.test;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/6/25 11:07
 * @Version 1.0
 */
@Component
public class TestApplicationListener implements ApplicationListener<WebServerInitializedEvent> {

    @Override
    public void onApplicationEvent(WebServerInitializedEvent webServerInitializedEvent) {
        System.out.println(webServerInitializedEvent);
    }
}
