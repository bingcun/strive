package ai.yuhan.other.designer.single;

/**
 * @Author: bingcun.chen
 * @Date: 2021/2/26 14:27
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class SingletonInstance {
    private volatile static SingletonInstance instance;
    private SingletonInstance(){}
    public SingletonInstance getSingletonInstance(){
        //第一次检测
        if(SingletonInstance.instance==null){
            //同步
            synchronized (SingletonInstance.class){
                if(SingletonInstance.instance==null){
                    //多线程环境下可能出现的问题,并发条件下可能发生指令重排
                    // 将 SingletonInstance.instance==null
                    //    instance = new SingletonInstance()
                    // 交换位置,那么就会发生问题,所以要进行双重校验
                    instance = new SingletonInstance();
                }
            }

        }
        return instance;
    }
}
