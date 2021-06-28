package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 *  @author: bingcun.chen
 * @Date: 2021/6/28 15:07
 * @Version 1.0
 */
public class offer61 {
    /**
     * 最大值与最小值之间最大小于5  max - min < 5
     * 不存在重复数据
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        int max = 0,min = 13;
        for(int num : nums){
            if(num == 0)continue;//排除大小王

            max = Math.max(max,num);//最大值
            min = Math.min(min,num);//最小值

            //是否有重复的数字
            if(sets.contains(num))return false;
            sets.add(num);
        }

        //最大值和最小值之间的差小于5
        return (max - min) < 5;
    }

    @Test
    public void test(){
        int[] nums = new int[]{0,0,1,2,5};
        System.out.println(isStraight(nums));
    }
}
