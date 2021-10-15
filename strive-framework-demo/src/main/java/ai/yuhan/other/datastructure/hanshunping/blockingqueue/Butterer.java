package ai.yuhan.other.datastructure.hanshunping.blockingqueue;

/**
 * @description: 涂了黄油的
 * @author: bingcun.chen
 * @Date: 2021/10/11 10:36
 * @Version 1.0
 */
public class Butterer implements Runnable{
    private ToastQueue dryQueue;
    private ToastQueue butteredQueue;
    public Butterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                //在取得下一个吐司之前会一直阻塞
                Toast toast = dryQueue.take();
                toast.butter();
                System.out.println(toast);
                butteredQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Butterer interrupted.");
        }
        System.out.println("Butterer off.");

    }
}
