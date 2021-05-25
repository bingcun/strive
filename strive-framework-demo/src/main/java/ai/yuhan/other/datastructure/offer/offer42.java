package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

/**
 * @description:
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 *
 * @author: bingcun.chen
 * @Date: 2021/5/24 19:22
 * @Version 1.0
 */
public class offer42 {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++){
            for(int j = i;j < nums.length;j++){
                // 计算sum(i,j)
                int sum = 0;
                for(int k = i;k<j;k++)
                    sum+=nums[k];
                if(sum > max)
                    max = sum;
            }
        }
        return max;
    }

    public int maxSubArray01(int[] nums){
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i] += Math.max(nums[i-1],0);
            res = Math.max(res,nums[i]);
        }
        return res;
    }

    @Test
    public void test(){
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArray01(arr));
    }
}
