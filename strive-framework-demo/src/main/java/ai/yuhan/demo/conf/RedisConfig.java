package ai.yuhan.demo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/6 20:54
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Component
public class RedisConfig {

    @Bean
    public RedisTemplate redisTemplate(){
        return new RedisTemplate();
    }

}
