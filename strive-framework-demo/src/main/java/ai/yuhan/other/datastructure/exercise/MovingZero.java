package ai.yuhan.other.datastructure.exercise;

import org.junit.Test;

/**
 * @description:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * @author: bingcun.chen
 * @Date: 2021/7/15 14:25
 * @Version 1.0
 */
public class MovingZero {
    /**
     * 移动数组中的0到数组的末尾
     * @param nums
     */
    public void moveZeroes(int[] nums) {
         int left = 0,right = 0;
         for(int i=0;i<nums.length;i++){
             if(nums[right] != 0){
                swapData(nums,left,right);
                left++;
             }
             right++;
         }
    }

    private void swapData(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }

    @Test
    public void test(){
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println();

    }

}
