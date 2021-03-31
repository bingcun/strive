package ai.yuhan.demo.rabbitmq.single.rountingkey;

import ai.yuhan.demo.rabbitmq.single.utils.RabbitConstant;
import ai.yuhan.demo.rabbitmq.single.utils.RabbitUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/28 16:46
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class WeatherBureau {

    public static void main(String[] args) throws IOException, TimeoutException {
        Map area = new LinkedHashMap<String, String>();
        area.put("china.hunan.changsha.20201127", "中国湖南长沙20201127天气数据");
        area.put("china.hubei.wuhan.20201127", "中国湖北武汉20201127天气数据");
        area.put("china.hunan.zhuzhou.20201127", "中国湖南株洲20201128天气数据");
        area.put("us.cal.lsj.20201127", "美国加州洛杉矶20201127天气数据");

        area.put("china.hebei.shijiazhuang.20201128", "中国河北石家庄20201128天气数据");
        area.put("china.hubei.wuhan.20201128", "中国湖北武汉20201128天气数据");
        area.put("china.henan.zhengzhou.20201128", "中国河南郑州20201128天气数据");
        area.put("us.cal.lsj.20201128", "美国加州洛杉矶20201128天气数据");

        //创建tcp连接
        Connection connection = RabbitUtils.getConnection();
        //创建Channel
        Channel channel = connection.createChannel();
        //创建交换机
        channel.exchangeDeclare(RabbitConstant.EXCHANGE_WEATHER_ROUTING,"direct");
        //获取输入的字符串
        Iterator<Map.Entry<String,String>> iterator = area.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            channel.basicPublish(RabbitConstant.EXCHANGE_WEATHER_ROUTING,next.getKey(),null,next.getValue().getBytes());
        }
        channel.close();
        connection.close();
    }


}
