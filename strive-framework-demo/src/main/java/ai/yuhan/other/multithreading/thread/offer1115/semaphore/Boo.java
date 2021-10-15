package ai.yuhan.other.multithreading.thread.offer1115.semaphore;

import lombok.SneakyThrows;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/7/30 10:47
 * @Version 1.0
 */
public class Boo implements Runnable{

    @SneakyThrows
    @Override
    public void run() {
        Sem.booSem.acquire();
        System.out.print("Boo");
        Sem.fooSem.release();
    }
}
