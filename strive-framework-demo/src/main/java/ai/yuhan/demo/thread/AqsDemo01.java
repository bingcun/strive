package ai.yuhan.demo.thread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/1 14:23
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class AqsDemo01 {

    private final Sync sync;


    abstract static class Sync extends AbstractQueuedSynchronizer {



    }

    static final class NonfairSync extends Sync{

    }

    static final class FairSync extends Sync{

    }


    public AqsDemo01(boolean fair){
        sync = fair? new NonfairSync():new FairSync();
    }





}
