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
import java.util.regex.Pattern;


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

    public static void main(String[] args) {
        System.out.println(isNumeric("jjj"));
    }



    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        if (str.indexOf(".") > 0) {//判断是否有小数点
            if (str.indexOf(".") == str.lastIndexOf(".") && str.split("\\.").length == 2) { //判断是否只有一个小数点
                return pattern.matcher(str.replace(".", "")).matches();
            } else {
                return false;
            }
        } else {
            return pattern.matcher(str).matches();
        }

    }
}
