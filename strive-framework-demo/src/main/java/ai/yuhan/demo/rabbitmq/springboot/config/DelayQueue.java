package ai.yuhan.demo.rabbitmq.springboot.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/30 22:24
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Configuration
public class DelayQueue {

    //1.声明延时队列(ttl+死信队列)
    //2.队列中两个参数 一个是x-message-ttl 10000过期时间, x-dead-letter-exchange 死信交换机(设置参数)
    //3.绑定原有的队列和交换机
    //4.声明死信队列,死信交换机互相绑定

    /**
     * 例如，如果你使用foo作为路由关键字发送了一条消息到交换机，当消息成为死信后，它使用foo作为路由关键字被发送到队列的死信交换机。
     * 如果队列在声明时指定"x-dead-letter-routing-key"的值为bar，那么消息被发送到死信交换机时将会使用bar作为路由关键字。
     * 注意，如果队列没有设置死信路由关键字，那消息被死信路由时将会使用它自身的原始路由关键字。
     * 这包含了CC和BCC头参数设置的路由关键字。
     * @return
     */
    @Bean
    public Queue ttlQueue(){
        return QueueBuilder
                .durable("strive_order_queue")
                .withArgument("x-message-ttl",10000)
                .withArgument("x-dead-letter-routing-key","dlx.order.cancel")
                .withArgument("x-dead-letter-exchange","strive_order_exchange_dlx")
                .build();
    }

    //2.声明延时交换机
    @Bean
    public TopicExchange exchangeDlx(){
        return new TopicExchange("strive_order_exchange");
    }

    //3.绑定延时队列和交换机
    @Bean
    public Binding bindingExchange(){
        return BindingBuilder.bind(ttlQueue()).to(exchangeDlx()).with("order.#");
    }

    //4.声明死信队列
    @Bean
    public Queue dlxQueue(){
        return QueueBuilder.durable("strive_order_queue_dlx").build();
    }

    @Bean
    public TopicExchange exchangedlx(){
        return new TopicExchange("strive_order_exchange_dlx");
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(dlxQueue()).to(exchangedlx()).with("dlx.order.#");
    }
}
