package ai.yuhan.other.multithreading.thread.offer1115.semaphore;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/7/30 11:01
 * @Version 1.0
 */
public class TestFooBoo {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Boo boo = new Boo();
        for(int n = 0;n<10;n++){
            foo.run();
            boo.run();
        }
    }
}
