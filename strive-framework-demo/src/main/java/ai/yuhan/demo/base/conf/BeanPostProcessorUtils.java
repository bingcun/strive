package ai.yuhan.demo.base.conf;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/22 8:57
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Component
public class BeanPostProcessorUtils implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(beanName.equals("emp")){
            System.out.println("走postProcessBeforeInitialization");
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("emp")){
            System.out.println("走postProcessAfterInitialization");
        }
        return bean;
    }
}