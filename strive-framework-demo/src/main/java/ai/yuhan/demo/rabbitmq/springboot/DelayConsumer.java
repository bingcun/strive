package ai.yuhan.demo.rabbitmq.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/31 13:52
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Component
@Slf4j
public class DelayConsumer {

    @RabbitListener(queues = "strive_order_queue_dlx")
    public void getDeadMessageQueue(String message){
        System.out.println("消费的消息是:"+message);
    }


}
