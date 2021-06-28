package ai.yuhan.demo.test;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/6/25 17:10
 * @Version 1.0
 */
public class LoadBlance {

    @Test
    public void test(){
        System.out.println(incrementAndGetModulo(10));
    }


    private AtomicInteger nextIndex = new AtomicInteger(0);
    private int incrementAndGetModulo(int modulo) {
        for (; ; ) {
            int current = nextIndex.get();
            int next = (current + 1) % modulo;
            if (nextIndex.compareAndSet(current, next) && current < modulo) {
                return current;
            }
        }
    }
}
