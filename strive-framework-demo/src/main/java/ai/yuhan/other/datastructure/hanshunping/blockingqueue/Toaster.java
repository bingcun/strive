package ai.yuhan.other.datastructure.hanshunping.blockingqueue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @description: 生产吐司的程序
 * @author: bingcun.chen
 * @Date: 2021/10/11 10:36
 * @Version 1.0
 */
public class Toaster implements Runnable{
    private ToastQueue toastsQueue;
    private int count = 0;
    private Random random = new Random(47);
    public Toaster(ToastQueue queue){
        this.toastsQueue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(300 + random.nextInt(500));
                Toast toast = new Toast(count++);
                System.out.println(toast);
                //放到toastQueue中
                toastsQueue.put(toast);
            }
        }catch (Exception e){
            System.out.println("Toaster interrupted.");
        }
        System.out.println("Toaster off.");
    }
}
