package ai.yuhan.other.multithreading.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/27 18:02
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class SyncDemo01 implements Runnable{

    private volatile static int total = 1000;

    private String obj = "lock";

    @Override
    public void run() {
        increaseCount();
    }

    private synchronized void increaseCount() {
        ReentrantLock reentrantLock = new ReentrantLock(false);
            for (int i=0;i<10;i++){
                total--;
                System.out.println("当前线程:"+Thread.currentThread().getName()+",数量:"+total);
            }
    }
}
