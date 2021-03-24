package ai.yuhan.permission.server;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/18 17:51
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@SpringBootApplication
@ComponentScan(basePackages = {"ai.yuhan.permission.server","ai.yuhan.core"})
@EnableDubbo
@EnableDiscoveryClient
public class StrivePermissionServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(StrivePermissionServerApplication.class,args);
    }
}
