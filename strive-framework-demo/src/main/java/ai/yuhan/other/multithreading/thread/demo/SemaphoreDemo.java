package ai.yuhan.other.multithreading.thread.demo;

import java.util.concurrent.Semaphore;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/3 10:41
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        
        Semaphore semaphore = new Semaphore(2);
        for(int i=0;i<10;i++){
            new Thread(new Task(semaphore)).start();
        }
    }

    public static class Task extends Thread{
        Semaphore semaphore;

        public Task(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(super.currentThread().getName());
                Thread.sleep(5000);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
