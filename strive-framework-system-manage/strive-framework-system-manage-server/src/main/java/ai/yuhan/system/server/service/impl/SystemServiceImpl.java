package ai.yuhan.system.server.service.impl;

import ai.yuhan.system.server.entity.Order;
import ai.yuhan.system.server.mq.send.TulingMsgSender;
import ai.yuhan.system.server.service.SystemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/14 12:47
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private TulingMsgSender sender;

    @Override
    public String testRabbitMq() {
        try {
            sender.sendOrderMsg(Order.builder().payMoney(100.50).userName("zhangsan").createDt(new Date()).orderNo("123456").build());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
