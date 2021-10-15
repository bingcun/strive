package ai.yuhan.other.multithreading.thread.offer1115.cyclicbarrier;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/7/31 16:04
 * @Version 1.0
 */
public class FooBar {
    private int n;
    private CyclicBarrier cy = new CyclicBarrier(2);
    volatile boolean fooException = true;

    public FooBar(int n){
        this.n = n;
    }

    public void foo(Runnable foo){
        for(int i = 0;i < n;i++){
            while (!fooException){

            }
            foo.run();
            fooException = false;
            try {
                cy.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void boo(Runnable boo){
        for(int i=0;i<n;i++){
            try {
                cy.await();
                boo.run();
                fooException = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

    }
}
