package ai.yuhan.demo.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/8/17 10:30
 * @Version 1.0
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessThread implements Runnable{

    private String acceptStr;

    @Override
    public void run() {
        System.out.println("多线程已经处理订单插入系统，订单号："+acceptStr);
    }
}
