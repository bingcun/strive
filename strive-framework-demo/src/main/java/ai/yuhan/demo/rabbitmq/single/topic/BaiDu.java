package ai.yuhan.demo.rabbitmq.single.topic;

import ai.yuhan.demo.rabbitmq.single.utils.RabbitConstant;
import ai.yuhan.demo.rabbitmq.single.utils.RabbitUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/28 16:53
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class BaiDu {
    public static void main(String[] args) throws IOException {
        //获取tcp连接
        Connection conn = RabbitUtils.getConnection();
        //获取channel
        Channel channel = conn.createChannel();
        //声明队列
        channel.queueDeclare(RabbitConstant.QUEUE_BAIDU,false,false,false,null);
        //绑定路由key
        channel.queueBind(RabbitConstant.QUEUE_BAIDU, RabbitConstant.EXCHANGE_WEATHER_TOPIC, "us.cal.lsj.20201127.*");
        //同一时刻只会发送一条给消费者
        channel.basicQos(1);

        channel.basicConsume(RabbitConstant.QUEUE_BAIDU,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("百度天气收到气象信息:" + new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });

    }


}