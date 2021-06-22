package ai.yuhan.other.desinger.writedesigner.strategy;

import lombok.Data;
import lombok.Getter;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/5/25 10:09
 * @Version 1.0
 */
@Getter
public enum ZombieType {
    //正常僵尸
    NORMAL_ZOMBIE,
    //骑手僵尸
    FLAG_ZOMBIE,
    //大头僵尸
    BIG_HEAD_ZOMBIE,
    //石膏僵尸
    GYPSUM_ZOMBIE;
}
