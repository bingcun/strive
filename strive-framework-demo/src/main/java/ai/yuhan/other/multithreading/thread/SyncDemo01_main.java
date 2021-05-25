package ai.yuhan.other.multithreading.thread;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/27 18:24
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class SyncDemo01_main {
    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            Thread thread01 = new Thread(new SyncDemo01(),"Thread"+i);
            thread01.start();
        }

    }


}
