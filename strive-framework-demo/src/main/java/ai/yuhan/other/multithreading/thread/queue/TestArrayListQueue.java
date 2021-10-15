package ai.yuhan.other.multithreading.thread.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @description: 多线程的模式下模拟BlockingQueue
 * @author: bingcun.chen
 * @Date: 2021/9/23 11:07
 * @Version 1.0
 */
public class TestArrayListQueue {

    public static void main(String[] args){
        //设置blocking的长度
        ArrayBlockingQueue<Integer> blkList = new ArrayBlockingQueue(10);

        new Thread(()->{
            int i = 0;
            while (true){
                try {
                    Thread.sleep(10000);
                    i++;
                    blkList.put(i);
                    System.out.println("存入数据"+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(1000);
                    Integer take = blkList.take();
                    System.out.println("取出数据"+take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();


    }



}
