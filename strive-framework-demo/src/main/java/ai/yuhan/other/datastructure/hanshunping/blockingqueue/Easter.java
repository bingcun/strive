package ai.yuhan.other.datastructure.hanshunping.blockingqueue;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/10/11 10:37
 * @Version 1.0
 */
public class Easter implements Runnable{
    private ToastQueue finishedQueue;
    private int count = 0;
    public Easter (ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                //在取得下一个吐司之前会一直阻塞
                Toast toast = finishedQueue.take();
                //验证取得的吐司是有序的，而且状态是JAMMED的
                if (toast.getId() != count++ ||
                        toast.getStatus() != Toast.Status.JAMMED) {
                    System.out.println("Error -> " + toast);
                    System.exit(-1);
                } else {
                    //吃掉吐司
                    System.out.println(toast + "->Eaten");
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Eater interrupted.");
        }
        System.out.println("Eater off.");
    }
}
