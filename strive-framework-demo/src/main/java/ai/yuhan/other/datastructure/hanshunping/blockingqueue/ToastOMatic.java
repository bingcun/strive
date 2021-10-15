package ai.yuhan.other.datastructure.hanshunping.blockingqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/10/11 10:38
 * @Version 1.0
 */
public class ToastOMatic {
    public static void main(String[] args) throws Exception {
        ToastQueue dryQueue = new ToastQueue();
        ToastQueue butteredQueue = new ToastQueue();
        ToastQueue finishedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue, butteredQueue));
        exec.execute(new Jammer(butteredQueue, finishedQueue));
        exec.execute(new Easter(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }





}
