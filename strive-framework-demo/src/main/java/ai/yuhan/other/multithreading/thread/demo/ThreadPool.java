package ai.yuhan.other.multithreading.thread.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/1 18:24
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
    }
}
