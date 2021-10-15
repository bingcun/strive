package ai.yuhan;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@ComponentScan(basePackages = {"ai.yuhan.system.server","ai.yuhan.core"})
@EnableDubbo
@EnableDiscoveryClient
@EnableTransactionManagement
public class StriveSystemManageServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(StriveSystemManageServerApplication.class,args);
    }
}