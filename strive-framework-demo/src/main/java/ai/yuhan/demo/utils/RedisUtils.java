package ai.yuhan.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/5/21 9:36
 * @Version 1.0
 */
@Component
public class RedisUtils {
    private static StringRedisTemplate REDIS_TEMPLATE;

    @Autowired
    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        REDIS_TEMPLATE = redisTemplate;
    }

    /**
     * 查询key的剩余生存时间
     *
     * @param key key
     * @return 剩余生存时间
     */
    public static Long ttl(String key) {
        return REDIS_TEMPLATE.getExpire(key);
    }

    /**
     * 设置过期时间
     *
     * @param key     key
     * @param seconds 过期时间-秒
     * @return flag
     */
    public static Boolean expire(String key, long seconds) {
        return REDIS_TEMPLATE.expire(key, seconds, TimeUnit.SECONDS);
    }

    /**
     * 值增加delta
     *
     * @param key   key
     * @param delta delta
     * @return 增加后的值
     */
    public static Long incr(String key, long delta) {
        return REDIS_TEMPLATE.opsForValue().increment(key, delta);
    }

    /**
     * 实现命令：KEYS pattern，查找所有符合给定模式 pattern的 key
     *
     * @param pattern pattern
     * @return keys
     */
    public static Set<String> keys(String pattern) {
        return REDIS_TEMPLATE.keys(pattern);
    }

    /**
     * 删除key
     *
     * @param key key
     */
    public static Boolean del(String key) {
        return REDIS_TEMPLATE.delete(key);
    }

    // ========================= String =============================

    /**
     * String-设置val
     *
     * @param key key
     * @param val val
     */
    public static void set(String key, String val) {
        REDIS_TEMPLATE.opsForValue().set(key, val);
    }

    /**
     * String-设置val
     *
     * @param key     key
     * @param val     val
     * @param seconds 过期时间-秒
     */
    public static void set(String key, String val, long seconds) {
        REDIS_TEMPLATE.opsForValue().set(key, val, seconds, TimeUnit.SECONDS);
    }

    /**
     * String-设置val
     *
     * @param key      key
     * @param val      val
     * @param timeout  过期时间
     * @param timeUnit 过期时间单位
     */
    public static void set(String key, String val, long timeout, TimeUnit timeUnit) {
        REDIS_TEMPLATE.opsForValue().set(key, val, timeout, timeUnit);
    }

    /**
     * String-获取val
     *
     * @param key key
     * @return value
     */
    public static String get(String key) {
        return REDIS_TEMPLATE.opsForValue().get(key);
    }

    /**
     * String-获取val集合
     *
     * @param keys keys
     * @return values
     */
    public static List<String> mget(List<String> keys) {
        return REDIS_TEMPLATE.opsForValue().multiGet(keys);
    }

    /**
     * 批量查询，管道pipeline
     *
     * @param keys keys
     * @return values
     */
    public static List<Object> batchGet(List<String> keys) {
        return REDIS_TEMPLATE.executePipelined((RedisCallback<String>) connection -> {
            StringRedisConnection src = (StringRedisConnection) connection;
            for (String k : keys) {
                src.get(k);
            }
            return null;
        });
    }

    // =========================== Hash ==================================

    /**
     * 实现命令：HSET key field value，将哈希表 key中的域 field的值设为 value
     *
     * @param key   key
     * @param field field
     * @param value value
     */
    public static void hset(String key, String field, Object value) {
        REDIS_TEMPLATE.opsForHash().put(key, field, value);
    }

    /**
     * 实现命令：HGET key field，返回哈希表 key中给定域 field的值
     *
     * @param key   key
     * @param field field
     * @return value
     */
    public static Object hget(String key, String field) {
        return REDIS_TEMPLATE.opsForHash().get(key, field);
    }

    /**
     * 实现命令：HDEL key field [field ...]，删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
     *
     * @param key    key
     * @param fields fields
     */
    public static void hdel(String key, Object... fields) {
        REDIS_TEMPLATE.opsForHash().delete(key, fields);
    }

    /**
     * 实现命令：HGETALL key，返回哈希表 key中，所有的域和值。
     *
     * @param key key
     * @return map
     */
    public static Map<Object, Object> hgetall(String key) {
        return REDIS_TEMPLATE.opsForHash().entries(key);
    }

    // =========================== List ==================================

    /**
     * 实现命令：LPUSH key value，将一个值 value插入到列表 key的表头
     *
     * @param key   key
     * @param value value
     * @return 执行 LPUSH命令后，列表的长度。
     */
    public static Long lpush(String key, String value) {
        return REDIS_TEMPLATE.opsForList().leftPush(key, value);
    }

    /**
     * 实现命令：LPOP key，移除并返回列表 key的头元素。
     *
     * @param key key
     * @return 列表key的头元素。
     */
    public static Object lpop(String key) {
        return REDIS_TEMPLATE.opsForList().leftPop(key);
    }

    /**
     * 实现命令：RPUSH key value，将一个值 value插入到列表 key的表尾(最右边)。
     *
     * @param key   key
     * @param value value
     * @return 执行 LPUSH命令后，列表的长度。
     */
    public static Long rpush(String key, String value) {
        return REDIS_TEMPLATE.opsForList().rightPush(key, value);
    }
}
