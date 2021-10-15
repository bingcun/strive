package ai.yuhan.demo.test;

import ai.yuhan.demo.utils.DelayTaskQueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/8/17 14:57
 * @Version 1.0
 */
public class TestDelayTaskQueue {


    public static void main(String[] args) throws InterruptedException {
        DelayQueue delayQueue = new DelayQueue();
        new Thread(new Runnable() {
            @Override
            public void run() {
                delayQueue.offer(new DelayTaskQueue("task1",2000));
                delayQueue.offer(new DelayTaskQueue("task2",1000));
                delayQueue.offer(new DelayTaskQueue("task3",4000));
                delayQueue.offer(new DelayTaskQueue("task4",3000));
                delayQueue.offer(new DelayTaskQueue("task5",5000));
                delayQueue.offer(new DelayTaskQueue("task6",6000));
                delayQueue.offer(new DelayTaskQueue("task7",5000));
            }
        }).start();

        while (true) {
            Delayed take = delayQueue.take();
            System.out.println(take);
        }

    }

}
