package ai.yuhan.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/6 20:52
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
@Component
public class RedisLock {

    private static final String LOCK_KEY_PREFIX = "LOCK-";

    private static ThreadLocal<AtomicInteger> threadLocal = new ThreadLocal<>();

    @Autowired
    private RedisTemplate redisTemplate;

    public static int getRandomInt(int Min , int Max){
        Random rand = new Random();
        return rand.nextInt(Max - Min + 1) + Min;
    }

    private static String createLockValue() {
        return String.valueOf(System.currentTimeMillis()) + "@" + getRandomInt(0,6);
    }

    /**
     * 获取锁
     *
     * @param key
     * @param timeOutMillis
     * @param tryCount
     * @param tryIntervalMillis
     * @return boolean
     */
    public boolean tryLock(String key, long timeOutMillis, int tryCount, long tryIntervalMillis) {
        String lockKey = LOCK_KEY_PREFIX + key;
        //如果已经获取过锁，则不需再获取
        if (threadLocal.get() != null) {
            //计算锁的深度
            threadLocal.get().incrementAndGet();
            return true;
        }
        for (int i = 0; i < tryCount; i++) {
            if (redisTemplate.opsForValue().setIfAbsent(lockKey, createLockValue())) {
                redisTemplate.expire(lockKey, timeOutMillis, TimeUnit.MILLISECONDS);
                return true;
            }
            if (tryCount > 1) {
                try {
                    Thread.sleep(tryIntervalMillis);
                } catch (InterruptedException e) {
                }
            }
        }
        // 防止死锁处理
        String lockValue = (String) redisTemplate.opsForValue().get(lockKey);
        if (lockValue != null) {
            long lockTime = Long.parseLong(lockValue.substring(0, lockValue.indexOf("@")));
            if (System.currentTimeMillis() - lockTime > timeOutMillis) {
                //如果并发设置的时候，判断哪个是锁的真正获得者
                String oldValue = (String) redisTemplate.opsForValue().getAndSet(lockKey, createLockValue());
                if (lockValue.equals(oldValue)) {
                    redisTemplate.expire(lockKey, timeOutMillis, TimeUnit.MILLISECONDS);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 释放锁
     *
     * @param key
     */
    public void releaseLock(String key) {
        redisTemplate.delete(LOCK_KEY_PREFIX + key);
        threadLocal.remove();
    }



}
