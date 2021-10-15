package ai.yuhan.other.multithreading.thread.offer1115.semaphore;

import lombok.SneakyThrows;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/7/30 10:36
 * @Version 1.0
 */
public class Foo implements Runnable{

    @SneakyThrows
    @Override
    public void run() {
        Sem.fooSem.acquire();
        System.out.print("Foo");
        Sem.booSem.release();
    }
}
