package ai.yuhan.demo.datastructure.leetcode.offer;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/19 16:13
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class DuplicateNumber {
    public static void main(String[] args) {
        int nums[] = {2,3,1,0,2,5,3};

        System.out.println(findRepeatNumber(nums));

    }

    public static int findRepeatNumber(int[] nums){
        int n = nums.length;
        for(int num:nums){
            if(num<0||num>=n){
                return -1;
            }
        }

        for(int i=0;i<n;i++){
            while (nums[i]!=i && nums[nums[i]]!=nums[i]){
                swap(nums,i,nums[i]);
            }

            if(nums[i]!=i && nums[nums[i]]==nums[i]){
                return nums[i];
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
