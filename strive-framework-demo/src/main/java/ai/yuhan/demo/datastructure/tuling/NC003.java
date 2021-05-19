package ai.yuhan.demo.datastructure.tuling;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * 寻找数组的中心索引
 * 数组中某一个下标，左右两边的元素之后相等，该下标即为中心索引
 * 思路：先统计出整个数组的总和，然后从第一个元素开始叠加
 * 总和递减当前元素，叠加递增当前元素，知道两个值相等
 *
 * @author: bingcun.chen
 * @Date: 2021/5/18 16:46
 * @Version 1.0
 */
public class NC003 {

    /**
     * 求数组的中心索引,首先求出来所有的数据的和
     * 然后判断左面累加的值是否等于总和减去左面的值
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int temp = 0;
        for(int i=0;i<nums.length;i++){
            temp = temp + nums[i];
            if(sum == temp) return i;
            sum = sum - nums[i];
        }
        return -1;
    }


    @Test
    public void test(){
        int[] nums = new int[]{1,5,2,3,3};
        System.out.println(pivotIndex(nums));


    }



}
