package ai.yuhan.demo.rabbitmq.springboot.compent;

import ai.yuhan.demo.rabbitmq.springboot.vo.MsgTxtBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/31 16:08
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Component
@Slf4j
public class MsgSender implements InitializingBean {
    @Autowired
    private TulingConfirmCallBack tulingConfirmCallBack;
    @Autowired
    private TulingRetrunCallBack tulingRetrunCallBack;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void senderMsg(MsgTxtBo msgTxtBo){
        log.info("发送的消息ID:{}",msgTxtBo.getMsgId());
        CorrelationData correlationData = new CorrelationData(msgTxtBo.getMsgId());
        rabbitTemplate.convertAndSend("topicExchange","changsha.*",msgTxtBo,correlationData);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        rabbitTemplate.setConfirmCallback(tulingConfirmCallBack);
        rabbitTemplate.setReturnCallback(tulingRetrunCallBack);
        //Bean初始化之前进行注入回调确认和返回值确认
        Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter);
    }
}
