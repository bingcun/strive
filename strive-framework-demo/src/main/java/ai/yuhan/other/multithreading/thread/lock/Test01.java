package ai.yuhan.other.multithreading.thread.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/8/15 13:36
 * @Version 1.0
 */
public class Test01 {
    private static int total = 0;
    private static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        ReentrantLock lock = new ReentrantLock();

        for(int i=0;i<10;i++){
            new Thread(()->{
                try {
                    countDownLatch.await();
                    for(int j=0;j<1000;j++){
                        synchronized (obj){
                            total++;
                        }
//                        lock.lock();
//                        lock.unlock();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
//                    lock.unlock();
                }finally {
//                    lock.unlock();
                }
            }).start();
        }

        Thread.sleep(1000);

        countDownLatch.countDown();

        Thread.sleep(2000);

        System.out.println(total);




    }

}
