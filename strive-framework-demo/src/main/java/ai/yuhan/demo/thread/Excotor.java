package ai.yuhan.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/18 15:15
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class Excotor {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i=0;i<10;i++){
            int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });

        }
    }
}
