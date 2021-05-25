package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * @author: bingcun.chen
 * @Date: 2021/5/24 20:20
 * @Version 1.0
 */
public class offer57 {
    /**
     * 和为s的两个数字
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> maps= new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(maps.containsKey(nums[i])){
                result[0] = nums[i];
                result[1] = nums[maps.get(nums[i])];
                return result;
            }else {
                maps.put(target - nums[i],i);
            }
        }
        return result;
    }

    @Test
    public void test(){
        int[] nums = new int[]{2,7,11,15};
        twoSum(nums,9);


    }


}
