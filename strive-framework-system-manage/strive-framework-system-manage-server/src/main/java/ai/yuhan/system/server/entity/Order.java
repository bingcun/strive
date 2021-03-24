package ai.yuhan.system.server.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/14 12:23
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Order implements Serializable {
    private String orderNo;
    private Date createDt;
    private double payMoney;
    private String userName;
}
