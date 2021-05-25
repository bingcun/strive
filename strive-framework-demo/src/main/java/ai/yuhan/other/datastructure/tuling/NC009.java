package ai.yuhan.other.datastructure.tuling;

import org.junit.Test;

/**
 * @description:
 * 给定一个数组,满足两个数相加之和等于target,有序队列
 * @author: bingcun.chen
 * @Date: 2021/5/19 22:40
 * @Version 1.0
 */
public class NC009 {

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int[] findArrIndex(int[] nums,int target){
        int[] result = new int[2];
        int length = nums.length;
        if(length == 2) {
            result[0] = 0;
            result[1] = 1;
            return result;
        }
        for(int i=0;i<length;i++){
            int other = target - nums[i];
            int start = i;
            int high = length -1;
            while (start <= high){
                int mid = (high - start) / 2 + start;
                if(nums[mid] < other){
                    start = mid + 1;
                }else if(nums[mid] > other){
                    high = mid -1;
                }else{
                    result[0] = i;
                    result[1] = mid;
                    return result;
                }
            }
        }
        return null;
    }

    @Test
    public void test(){
        int[] arr = new int[]{1,1,3,4,5};
        int[] arrIndex = findArrIndex(arr, 6);

        System.out.println(arrIndex);

    }


}
