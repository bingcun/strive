package ai.yuhan.other.desinger.writedesigner.strategy;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/5/25 10:16
 * @Version 1.0
 */
public class NormalZombie extends Zombie{
    public NormalZombie(){
        super(new StepByStepMove(),new BiteAttack());
    }

    public NormalZombie(Moveable moveable, Attactable attactable) {
        super(moveable, attactable);
    }

    @Override
    void display() {
        System.out.println("我是普通僵尸...");
    }

    @Override
    void move() {
        moveable.move();
    }

    @Override
    void attack() {
        attactable.attach();
    }
}
