package ai.yuhan.other.datastructure.juide;

import org.junit.Test;

/**
 * @description:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 *
 * 输入：nums =[1,2,3,4] 1,2,3,4,5
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * @author: bingcun.chen
 * @Date: 2021/8/22 21:01
 * @Version 1.0
 */
public class Test3_3_15 {

    /**
     * 双指针法交换数组的位置
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int left = 0,right = nums.length -1;
        while (left < right){
            if(nums[left] % 2 != 0){
                left++;
            }else {
                if(nums[right] % 2 != 0){
                    swapNums(nums,left,right);
                    right--;
                }else {
                    right--;
                }
            }

        }
        return nums;
    }
    private void swapNums(int[] nums,int left,int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }


    /**
     * 尝试用两个数组解决
     * @param nums
     * @return
     */
    public int[] exchange01(int[] nums){
        int[] nums01 = new int[nums.length];
        int[] nums02 = new int[nums.length];

        int left = 0;
        int right = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] % 2 != 0){
                nums01[left] = nums[i];
                left++;
            }else {
                nums02[right] = nums[i];
                right++;
            }
        }
        System.arraycopy(nums02,0,nums01,left,nums01.length - left);
        return nums01;
    }


    @Test
    public void test(){
        int[] arr = new int[]{1,2,3,4,5,6};
        int[] exchange = exchange01(arr);
        System.out.println();

    }



    public static void main(String[] args) {

        System.out.println(5%2);

    }

}
