package ai.yuhan.demo.rabbitmq.single.pubsub;

import ai.yuhan.demo.rabbitmq.single.utils.RabbitConstant;
import ai.yuhan.demo.rabbitmq.single.utils.RabbitUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/28 16:46
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class WeatherBureau {

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建tcp连接
        Connection connection = RabbitUtils.getConnection();
        //创建Channel
        Channel channel = connection.createChannel();
        //获取输入的字符串
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String next = scanner.next();
            if(next.equals("exit"))break;
            channel.exchangeDeclare(RabbitConstant.EXCHANGE_WEATHER,"fanout");
            channel.basicPublish(RabbitConstant.EXCHANGE_WEATHER,"",null,next.getBytes());
        }
        channel.close();
        connection.close();
    }


}
