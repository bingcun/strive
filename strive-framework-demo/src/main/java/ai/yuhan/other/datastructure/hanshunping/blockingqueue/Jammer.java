package ai.yuhan.other.datastructure.hanshunping.blockingqueue;

/**
 * @description: 涂了果酱的
 * @author: bingcun.chen
 * @Date: 2021/10/11 10:36
 * @Version 1.0
 */
public class Jammer implements Runnable{
    private ToastQueue butteredQueue;
    private ToastQueue finishedQueue;
    public Jammer(ToastQueue butteredQueue, ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                //在取得下一个吐司之前会一直阻塞
                Toast toast = butteredQueue.take();
                toast.jam();
                System.out.println(toast);
                finishedQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Jammer interrupted.");
        }
        System.out.println("Jammer off.");
    }
}
