package ai.yuhan.system.server.mq.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.io.IOException;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/14 12:27
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Slf4j
public class TulingConfirmCallBack implements RabbitTemplate.ConfirmCallback {
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info("correlationData:========>{}",correlationData.getId());
        log.info("ack:================{}",ack);
        if(ack){
            log.info("mq生产段消息已经投递到了broker,更新我们的消息日志表");
        }else{
            log.warn("mq生产段没有被broker ack,原因:{}",cause);
        }



    }
}
