package ai.yuhan.demo.base.conf;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/22 7:57
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Component
public class InitializingBeanUtils implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Bean
    public Emp emp(){
        return new Emp();
    }

}
