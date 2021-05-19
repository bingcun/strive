package ai.yuhan.demo.datastructure.tuling;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * 三个数最大乘积:
 * @author: bingcun.chen
 * @Date: 2021/5/18 18:55
 * @Version 1.0
 */
public class NC006 {
    /**
     * 数组中存储三个数据,然后计算三个数据的最大乘积
     * @param nums
     * @return
     */
    public static int sort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0]*nums[1]*nums[n-1],nums[n-3]*nums[n-2]*nums[n-1]);
    }

    @Test
    public void test(){
        int[] sums = new int[]{115,125,135};
        int sort = sort(sums);
        System.out.println(sort);


    }

}
