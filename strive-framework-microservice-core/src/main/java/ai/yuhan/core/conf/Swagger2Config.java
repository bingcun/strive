package ai.yuhan.core.conf;

import ai.yuhan.core.conf.properties.ApiDocketProperties;
import ai.yuhan.core.conf.properties.StriveProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;


@Component
@EnableSwagger2
public class Swagger2Config implements ApplicationContextAware {
    @Autowired
    private StriveProperties striveProperties;

    private ConfigurableListableBeanFactory beanFactory;
    private DefaultListableBeanFactory defaultListableBeanFactory;
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        if(this.striveProperties.getApiDoc().getDockets()!=null && this.striveProperties.getApiDoc().getDockets().size()>0){
            this.striveProperties.getApiDoc().getDockets().forEach(n->{
                registerDocketBean(n.getBeanName(),n);
            });
        }

    }

    private void registerDocketBean(String beanName, ApiDocketProperties apiDocketProperties) {
        beanFactory.registerSingleton(beanName,apiDocketProperties.getDocket());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        if (applicationContext instanceof AbstractRefreshableApplicationContext) {
            this.beanFactory = ((AbstractRefreshableApplicationContext)applicationContext).getBeanFactory();
        } else {
            this.beanFactory = ((GenericApplicationContext)applicationContext).getBeanFactory();
            this.defaultListableBeanFactory = ((GenericApplicationContext)applicationContext).getDefaultListableBeanFactory();
        }
    }
}
