package ai.yuhan.system.server.mq.conf;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.SerializerMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import sun.nio.cs.FastCharsetProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/14 12:03
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Configuration
public class RabbitmqConfig {
    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host,port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        connectionFactory.setPublisherConfirms(true);
        connectionFactory.setPublisherReturns(true);
        return connectionFactory;
    }


    @Bean
    public DirectExchange tulingBootDirectExchange(){
        DirectExchange directExchange = new DirectExchange("springboot.direct.exchange",true, false);
        return directExchange;
    }
//    @Bean
//    public CustomExchange delayExchange(){
//        Map<String,Object> args = new HashMap<>();
//        args.put("x-delayed-type", "direct");
//        return new CustomExchange("delayExchange", "x-delayed-message",true, false,args);
//    }
    @Bean
    public Queue tulingBootQueue() {
        Queue queue = new Queue("tulingBootQueue",true,false,false);
        return queue;
    }

    @Bean
    public Queue tulingClusterQueue() {
        Queue queue = new Queue("tulingClusterQueue",true,false,false);
        return queue;
    }

    @Bean
    public Queue tulingBootDelayQueue() {
        Queue queue = new Queue("tulingBootDelayQueue",true,false,false);
        return queue;
    }

    @Bean
    public Binding tulingBootBinder(){
        return BindingBuilder.bind(tulingBootQueue()).to(tulingBootDirectExchange()).with("springboot.key");
    }

    @Bean
    @Scope("prototype")
    public RabbitTemplate createRabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setReturnCallback(new TulingReturnCallBack());
        rabbitTemplate.setConfirmCallback(new TulingConfirmCallBack());
        return rabbitTemplate;
    }


}
