package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * @author: bingcun.chen
 * @Date: 2021/6/27 16:08
 * @Version 1.0
 */
public class offer21 {

    /**
     * 通过数组进行交换
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        Arrays.sort(nums);
        int[] num01 = new int[nums.length];
        Arrays.fill(num01,-1);
        int[] num02 = new int[nums.length];
        Arrays.fill(num02,-1);

        int temp01 = 0;
        int temp02 = 0;
        for (int i=0;i<nums.length;i++) {
            if(nums[i] % 2 == 0){
                num02[temp01++] = nums[i];
            }else {
                num01[temp02++] = nums[i];
            }
        }
        if(temp01 == 0)return num01;
        temp01 = 0;
        for(int j = temp02;j<num01.length;j++){
            num01[j] = num02[temp01++];
        }
        return num01;
    }

    /**
     * 双指针法
     * @param nums
     * @return
     */
    public int[] exchange01(int[] nums){
        int left = 0,right = nums.length -1;
        while (left < right){
            while (left < right && (nums[left] & 1) == 1){
                left ++;
            }

            while (left < right && (nums[right] & 1) == 0){
                right --;
            }

            if(left<right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }

        return nums;
    }

    @Test
    public void test(){
        int[] nums = new int[]{1,2,3,4};

        int[] exchange = exchange01(nums);
        System.out.println(Arrays.toString(exchange));

    }

}
