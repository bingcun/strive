package ai.yuhan.other.multithreading.thread.pool;

import ai.yuhan.other.multithreading.thread.threadlocal.TestThreadLocal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/8/16 17:01
 * @Version 1.0
 */
public class MyThreadPool {

    public static Integer total = 0;
    private static Object obj = new Object();


    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
                200, 5000, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(100));

        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 1000; i++) {
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        lock.lock();
                        total++;
                        lock.unlock();
                    }
//                    System.out.println(1111);
                }
            });
        }

        Thread.sleep(3000);
        System.out.println(total);

        threadPoolExecutor.shutdown();
        threadPoolExecutor.shutdownNow();

    }

}
