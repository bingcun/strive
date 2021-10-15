package ai.yuhan.demo.conf;

import ai.yuhan.demo.business.BusinessThread;
import ai.yuhan.demo.utils.DelayTaskQueue;
import ai.yuhan.demo.utils.RedisUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Queue;
import java.util.concurrent.*;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/8/17 10:05
 * @Version 1.0
 */
@Component
public class ThreadPoolManagerConfig implements BeanFactoryAware {

    private BeanFactory factory;

    // 线程池维护核心线程数量
    private final static int CORE_POOL_SIZE = 2;
    // 线程池维护线程的最大数量
    private final static int MAX_POOL_SIZE = 10;
    // 线程池维护线程所允许的空闲时间
    private final static int KEEP_ALIVE_TIME = 0;
    // 线程池所使用的缓冲队列大小
    private final static int WORK_QUEUE_SIZE = 50;



    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        factory = beanFactory;
    }

    /**
     * 缓存直接打过来的订单到redis里面，然后根据Key值进行获取
     */
//    Map<String,Object> cacheMap = new ConcurrentHashMap<>();

    /**
     * 订单的缓存队列，当线程池满了，则将订单存入此缓存队列中
     */
    Queue<Object> msgQueue = new LinkedBlockingQueue<Object>();

    /**
     * 当线程池的容量满了，执行下面的代码，将订单存入到缓存队列
     */
    final RejectedExecutionHandler handler = new RejectedExecutionHandler(){
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            msgQueue.offer(((BusinessThread)r).getAcceptStr());
            System.out.println("系统任务太忙了,把此订单交给(调度线程池)逐一处理，订单号：" + ((BusinessThread) r).getAcceptStr());
        }
    };

    /**
     * 创建线程池
     */
    final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE,
            MAX_POOL_SIZE,KEEP_ALIVE_TIME,TimeUnit.SECONDS, new ArrayBlockingQueue(WORK_QUEUE_SIZE), this.handler);

    /**
     * 将任务加入到订单线程池
     * @param orderId
     */
    public void addOrders(String orderId){
        System.out.println("此订单准备添加到线程池，订单号：" + orderId);
        if(StringUtils.isEmpty(RedisUtils.get(orderId))){
            RedisUtils.set(orderId,orderId,10000);
            BusinessThread businessThread = new BusinessThread(orderId);
            threadPool.execute(businessThread);
        }
    }

    /**
     * 线程池的定时任务-----> 称为(调度线程池)。此线程池支持 定时以及周期性执行任务的需求
     */
    final ScheduledExecutorService schedual = Executors.newScheduledThreadPool(5);

    /**de
     * 检查(调度线程池)，每秒执行一次，查看订单的缓冲队列是否有 订单记录，则重新加入到线程池
     */
    final ScheduledFuture scheduledFuture = schedual.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
            if(!msgQueue.isEmpty()){
                if(threadPool.getQueue().size() < WORK_QUEUE_SIZE){
                    String orderId = (String)msgQueue.poll();
                    BusinessThread businessThread = new BusinessThread(orderId);
                    threadPool.execute(businessThread);
                    System.out.println("(调度线程池)缓冲队列出现订单业务，重新添加到线程池，订单号："+orderId);
                }
            }
        }
    },0,1,TimeUnit.SECONDS);

    /**获取消息缓冲队列*/
    public Queue<Object> getMsgQueue(){
        return msgQueue;
    }

    /**终止订单线程池+调度线程池*/
    public void shutdown(){
        System.out.println("终止订单线程池+调度线程池："+scheduledFuture.cancel(false));
        schedual.shutdown();
        threadPool.shutdown();
        DelayQueue<DelayTaskQueue> queue = new DelayQueue<DelayTaskQueue>();
    }
}
