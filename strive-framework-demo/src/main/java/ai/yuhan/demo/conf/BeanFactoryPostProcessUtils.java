package ai.yuhan.demo.conf;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/22 11:03
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Component
public class BeanFactoryPostProcessUtils implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("走BeanFactoryPostProcessor的postProcessBeanFactory()方法");
    }
}
