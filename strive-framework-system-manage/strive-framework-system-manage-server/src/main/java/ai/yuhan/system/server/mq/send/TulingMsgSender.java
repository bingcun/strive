package ai.yuhan.system.server.mq.send;

import ai.yuhan.system.server.entity.Order;
import ai.yuhan.system.server.mq.conf.TulingConfirmCallBack;
import ai.yuhan.system.server.mq.conf.TulingReturnCallBack;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/14 12:17
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Component
public class TulingMsgSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

   public void sendOrderMsg(Order order) throws JsonProcessingException {
       //构建correlationData 用于做可靠性投递,ID:必须为全局唯一的 根据业务规则
       CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());

       ObjectMapper objectMapper = new ObjectMapper();
       String orderJson = objectMapper.writeValueAsString(order);
       org.springframework.amqp.core.MessageProperties messageProperties = new MessageProperties();
       org.springframework.amqp.core.Message message = new org.springframework.amqp.core.Message(orderJson.getBytes(),messageProperties);
       rabbitTemplate.convertAndSend("springboot.direct.exchange","springboot.key",message,correlationData);
   }
}
