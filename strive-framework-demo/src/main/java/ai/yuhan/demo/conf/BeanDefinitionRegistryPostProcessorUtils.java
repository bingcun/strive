//package ai.yuhan.demo.conf;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.beans.factory.support.BeanDefinitionRegistry;
//import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
//import org.springframework.stereotype.Component;
//
///**
// * @Author: bingcun.chen
// * @Date: 2021/2/22 10:35
// * @Version: 1.0
// * @Email: 820306546@qq.com
// */
//@Component
//public class BeanDefinitionRegistryPostProcessorUtils implements BeanDefinitionRegistryPostProcessor {
//    @Override
//    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
//        System.out.println("走BeanDefinitionRegistryPostProcessor的postProcessBeanDefinitionRegistry方法");
//    }
//
//    @Override
//    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
//        System.out.println("走BeanDefinitionRegistryPostProcessor的postProcessBeanFactory方法");
//    }
//}
