package ai.yuhan.demo.conf;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/22 11:21
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Component
public class FactoryBeanUtils implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        System.out.println("走factoryBean的getObject()方法");
        return new Persion();
    }

    @Override
    public Class<?> getObjectType() {
        return Persion.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext applicationContext =
//                new AnnotationConfigApplicationContext();
//        applicationContext.scan("ai.yuhan.demo.conf");
//        applicationContext.refresh();
//
////        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//
//    }
}
