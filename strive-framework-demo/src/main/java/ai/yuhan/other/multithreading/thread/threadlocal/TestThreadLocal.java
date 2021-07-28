package ai.yuhan.other.multithreading.thread.threadlocal;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/7/27 16:49
 * @Version 1.0
 */
public class TestThreadLocal {

    private static ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();


    public void set(Long ids){
        longThreadLocal.set(ids);
    }

    public Long get(){
        return longThreadLocal.get();
    }

    public static void remove(){
        longThreadLocal.remove();
    }

}
