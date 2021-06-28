package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * 示例2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * @author: bingcun.chen
 * @Date: 2021/6/28 10:10
 * @Version 1.0
 */
public class offer53_2 {

    /**
     * 找到缺失的数字 二分查找法计算缺少的值
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int i = 0,j = nums.length -1;

        while (i <= j){
            int mid = (i + j)/2;
            if(nums[mid] == mid){
                i = mid + 1;
            }else {
                j = mid - 1;
            }
        }
        return i;
    }


    /**
     * 解法2:理论上的和-实际数组的和即为缺失数据的值
     * sum = 2/n(n+1)
     * @param nums
     * @return
     */
    public int missingNumber01(int[] nums){
        int sum = (nums.length * (nums.length + 1)) / 2;
        return sum - Arrays.stream(nums).sum();
    }

    @Test
    public void test(){
        int[] nums = new int[]{0};
        int i = missingNumber(nums);
        System.out.println(i);
    }

}
