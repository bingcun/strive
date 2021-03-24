package ai.yuhan.demo.conf;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/22 7:39
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Component
public class ApplicationContextAwareUtils implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        System.out.println("走ApplicationContext方法");
        ApplicationContextAwareUtils.context = context;
    }

    public ApplicationContextAwareUtils(){
        System.out.println("走ApplicationContextAwareUtils类的构造方法");
    }

    @PostConstruct
    public void init(){
        System.out.println(String.format("走ApplicationContext的@PostConstrduct的init方法"));
    }


    public static ApplicationContext getApplicationContext(){
        return context;
    }

    /**
     * 通过beanName获取实例bean
     * @param beanName
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName){
        return (T) context.getBean(beanName);
    }

    /**
     * 通过类型获取实例bean,但是如果在spring容器中通过相同的类
     * 的不同构造器创建两个不同的对象，通过类型则获取不到对象
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<?> clazz){
        return (T) context.getBean(clazz);
    }
}
