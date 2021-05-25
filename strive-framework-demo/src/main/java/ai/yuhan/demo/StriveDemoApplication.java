package ai.yuhan.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/22 7:28
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@SpringBootApplication
@MapperScan("ai.yuhan.demo.mapper")
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class StriveDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(StriveDemoApplication.class,args);
    }
}
