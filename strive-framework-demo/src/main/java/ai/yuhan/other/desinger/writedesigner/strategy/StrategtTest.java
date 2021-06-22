package ai.yuhan.other.desinger.writedesigner.strategy;

/**
 * @description:
 * 类型    外观 移动                   攻击
 * 普通僵尸 普通 朝着一个方向移动           咬
 * 旗手僵尸 普通+手持旗子 朝着一个方向移动    咬
 * 大头僵尸 大头 朝着一个方向移动           头撞
 * 石膏僵尸 石膏装 一拐一瘸                武器
 * XXX僵尸 ... ... ...
 * @author: bingcun.chen
 * @Date: 2021/5/25 10:01
 * @Version 1.0
 */
public class StrategtTest {
    public static void main(String[] args) {
        NormalZombie normalZombie = new NormalZombie();
        normalZombie.display();
        normalZombie.move();
        normalZombie.attack();




    }


}
