package ai.yuhan.demo.thread;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/25 17:34
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class Jmm03 {

    public static Boolean flag = false;

    public volatile static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        //加volatile的话如果A线程修改了共享变量的值会主动推送给B线程
        //线程A,线程B有一个共享变量的值flag,
        //当线程A启动的时候,初始化一块内存,开辟一块工作区间,里面需要用到共享变量flag,
        //那么会在线程A的工作区间初始化一个线程的值load到线程A的工作内存中,flag = false,方便线程以后调用都在自己的工作区间里面
        //当线程B启动的时候,初始化一块内存,开辟一块工作区间,当线程B修改共享变量里面的值的时候
        //首先在工作区间内初始化共享变量的值flag=true,然后在修改共享变量的值
        Thread threadA = new Thread(()->{
            while (!flag){
                count ++;
            }
            System.out.println("线程A嗅探到共享变量的变化");
        });
        threadA.start();

        threadA.sleep(500);

        Thread threadB = new Thread(()->{

            refreshFlag();

        });

        threadB.start();
    }

    private static void refreshFlag() {
        System.out.println("线程B修改共享变量的值");
        flag = true;
    }


}
