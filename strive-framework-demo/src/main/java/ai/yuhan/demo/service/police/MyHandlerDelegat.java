package ai.yuhan.demo.service.police;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.naming.InitialContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/9/20 11:33
 * @Version 1.0
 */
@Component
public class MyHandlerDelegat implements ApplicationContextAware, InitializingBean {
    private ApplicationContext applicationContext;
    private final Map<String, AbstractSignHandler> handlerMap = new ConcurrentHashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        applicationContext.getBeansOfType(AbstractSignHandler.class).forEach((k,v)->{
            if(v.route() == null)return;
            handlerMap.put(v.route(),v);
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public AbstractSignHandler selectHandler(String route){
        return handlerMap.get(route);
    }
}
