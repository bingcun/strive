package ai.yuhan.demo.utils;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/8/17 13:51
 * @Version 1.0
 */
public class DelayTaskQueue implements Delayed {
    private String name;
    private long time;
    private Long start = System.currentTimeMillis();

    public DelayTaskQueue(String name,long time){
        this.name = name;
        this.time = time;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert((start+time) - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayTaskQueue o1 = (DelayTaskQueue)o;
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        return "DelayTaskQueue{" +
                "name='" + name + '\'' +
                ", start=" + start +
                ", time=" + time +
                '}';
    }
}
