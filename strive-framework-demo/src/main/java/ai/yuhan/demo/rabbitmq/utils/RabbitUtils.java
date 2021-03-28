package ai.yuhan.demo.rabbitmq.utils;

import com.rabbitmq.client.ConnectionFactory;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/28 11:12
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class RabbitUtils {

    /**
     * 获取Mq连接
     * @return
     */
    public ConnectionFactory getConnectionFactory(){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setVirtualHost("chenbingcun");
        factory.setHost("172.16.74.170");
        factory.setPort(5672);
        factory.setUsername("chenbingcun");
        factory.setPassword("chenbingcun");
        return factory;
    }


}
