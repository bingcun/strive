package ai.yuhan.gateway.conf;

import lombok.NoArgsConstructor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/20 16:16
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Configuration
@NoArgsConstructor
public class RestTemplateConfig {

    @LoadBalanced
    @Bean("loadBalancedRestTemplate")
    public RestTemplate loadBalancedRestTemplate(){
        return new RestTemplate();
    }


}
