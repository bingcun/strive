package ai.yuhan.demo.rocketmq.utils;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;

/**
 * @Author: bingcun.chen
 * @Date: 2021/4/1 17:17
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class RocketMqConnection {

    public static DefaultMQProducer getDefaultMQProducer() throws MQClientException {
        //指明rocketmq属于哪个组
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("springBootGroup");
        //设置连接地址
        defaultMQProducer.setNamesrvAddr("172.16.74.170:9876");
        defaultMQProducer.start();
        return defaultMQProducer;
    }


}
