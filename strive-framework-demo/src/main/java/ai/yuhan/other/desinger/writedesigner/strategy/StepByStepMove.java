package ai.yuhan.other.desinger.writedesigner.strategy;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/5/25 10:35
 * @Version 1.0
 */
public class StepByStepMove implements Moveable{
    @Override
    public void move() {
        System.out.println("一步一移动...");
    }


    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
         /** * 指定触发的时间 现在指定时间为  2013年10月27号15点 43 分 1 秒时触发 */
        calendar.set(Calendar.DAY_OF_MONTH,27);//设置日期为27号
        calendar.set(Calendar.MONTH, 10);//设置日期为11月份  这里10表示11月份 11就表示12月份
        calendar.set(Calendar.HOUR_OF_DAY, 15); //设置15点的时候触发
        calendar.set(Calendar.MINUTE, 43); //设置43分钟的时候触发
        calendar.set(Calendar.SECOND, 1); //设置第一秒的时候触发
        Date time = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new RemindTask(), time);
    }
}
class RemindTask extends TimerTask {
    public void run() {
        System.out.println("你指定2013-11-27号15:34:01分执行已经触发！");
    }
}
