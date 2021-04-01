package ai.yuhan.demo.rocketmq.batch;

import ai.yuhan.demo.rocketmq.mqconst.MqUtils;
import ai.yuhan.demo.rocketmq.utils.RocketMqConnection;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: bingcun.chen
 * @Date: 2021/4/1 17:03
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class SimpleBatchProducer {
    public static void main(String[] args) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {

        //获取rocketmq连接方式
        DefaultMQProducer defaultMQProducer = RocketMqConnection.getDefaultMQProducer();

        //声明topic主题
        String topic = "TopicTest";
        //发送消息
        List<Message> message = new ArrayList<>();
        message.add(new Message(MqUtils.ROCKETMQ_TOPIC,"Tag","OrderID001","HelloWord 0".getBytes()));
        message.add(new Message(MqUtils.ROCKETMQ_TOPIC,"Tag","OrderID002","HelloWord 1".getBytes()));
        message.add(new Message(MqUtils.ROCKETMQ_TOPIC,"Tag","OrderID003","HelloWord 2".getBytes()));

        //发送消息
        defaultMQProducer.send(message);
        defaultMQProducer.shutdown();
    }
}
