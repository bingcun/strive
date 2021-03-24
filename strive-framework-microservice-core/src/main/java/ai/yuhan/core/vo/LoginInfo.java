package ai.yuhan.core.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/25 23:41
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo implements Serializable {
    protected Map<String, Object> subject;
    protected String clientIp;
}
