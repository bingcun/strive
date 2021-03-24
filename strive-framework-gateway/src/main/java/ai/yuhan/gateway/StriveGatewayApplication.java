package ai.yuhan.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/19 15:45
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StriveGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(StriveGatewayApplication.class,args);
    }
}
