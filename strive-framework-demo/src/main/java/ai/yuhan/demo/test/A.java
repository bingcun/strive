package ai.yuhan.demo.test;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/2 11:27
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class A extends AbstractQueuedSynchronizer implements B{

    public static void main(String[] args) {
        int i;
        A a1 = new A();
        i = a1.k;
        System.out.println(i);

        ReentrantLock lock = new ReentrantLock();





    }
}
