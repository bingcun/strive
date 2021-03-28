package ai.yuhan.demo.rabbitmq.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;



public class RabbitUtils {
    private static ConnectionFactory connectionFactory = new ConnectionFactory();
    static {
        connectionFactory.setHost("172.16.74.170");
        connectionFactory.setPort(5672);//5672是RabbitMQ的默认端口号
        connectionFactory.setUsername("chenbingcun");
        connectionFactory.setPassword("chenbingcun");
        connectionFactory.setVirtualHost("chenbingcun");
    }
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = connectionFactory.newConnection();
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
