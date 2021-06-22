package ai.yuhan.other.desinger.writedesigner.strategy;

import lombok.Data;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/5/25 10:19
 * @Version 1.0
 */
@Data
public abstract class Zombie {

    abstract void display();

    Moveable moveable;

    Attactable attactable;

    public Zombie(Moveable moveable,Attactable attactable){
        this.moveable = moveable;
        this.attactable = attactable;
    }

    abstract void move();
    abstract void attack();


}
