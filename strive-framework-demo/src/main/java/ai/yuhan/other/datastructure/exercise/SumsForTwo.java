package ai.yuhan.other.datastructure.exercise;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 *
 * 示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 *
 * @author: bingcun.chen
 * @Date: 2021/7/16 17:31
 * @Version 1.0
 */
public class SumsForTwo {

    /**
     * 寻找两个数
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum01(int[] numbers, int target) {
        int[] nums = new int[2];
        Map<Integer,Integer> maps = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if(maps.containsKey(numbers[i])){
                Integer size = maps.get(numbers[i]);
                nums[0] = ++size;
                nums[1] = ++i;
                return nums;
            }else {
                maps.put(target - numbers[i],i);
            }
        }
        return null;
    }


    /**
     * 双指针法求目标值
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum02(int[] numbers, int target) {
       int left = 0,right = 1;
       for(int i=0;i<numbers.length;i++){
           for(int j=i+1;j<numbers.length;j++){
                if(target - numbers[i] == numbers[j]){
                    return new int[]{i + 1,j + 1};
                }
           }
       }
        return null;
    }

    @Test
    public void test(){
        int[] nums = new int[]{2,7,11,15};
        int[] ints = twoSum02(nums, 9);
        System.out.println(ints);
    }


}
