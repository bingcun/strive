//package ai.yuhan.demo.distributedlock;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//
///**
// * @Author: bingcun.chen
// * @Date: 2021/3/6 21:03
// * @Version: 1.0
// * @Email: 820306546@qq.com
// */
//public class RedissionLock {
//
//
//
//    public static boolean acquireLock(String lock) {
//        // 1. 通过SETNX试图获取一个lock
//        boolean success = false;
//        Jedis jedis = lettuce.getResource();
//        long value = System.currentTimeMillis() + expired + 1;
//        System.out.println(value);
//        long acquired = jedis.setnx(lock, String.valueOf(value));
//        //SETNX成功，则成功获取一个锁
//        if (acquired == 1)
//            success = true;
//            //SETNX失败，说明锁仍然被其他对象保持，检查其是否已经超时
//        else {
//            long oldValue = Long.valueOf(jedis.get(lock));
//
//            //超时
//            if (oldValue < System.currentTimeMillis()) {
//                String getValue = jedis.getSet(lock, String.valueOf(value));
//                // 获取锁成功
//                if (Long.valueOf(getValue) == oldValue)
//                    success = true;
//                    // 已被其他进程捷足先登了
//                else
//                    success = false;
//            }
//            //未超时，则直接返回失败
//            else
//                success = false;
//        }
//        pool.returnResource(jedis);
//        return success;
//    }
//
//}
