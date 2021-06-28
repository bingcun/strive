package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *  
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: bingcun.chen
 * @Date: 2021/6/27 21:43
 * @Version 1.0
 */
public class offer39 {

    @Test
    public void test(){
        int[] nums = new int[]{1,2,3,2,2,2,5,4,2};
        int target = 10;
        long count = Arrays.stream(nums).filter(ns -> ns == target).count();
        Integer.parseInt(String.valueOf(count));
    }

    @Test
    public void test01(){
        int[] nums = new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(majorityElement01(nums));
    }

    public int majorityElement(int[] nums) {
        Map<Integer,Integer> maps = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(maps.containsKey(nums[i])){
                int count = maps.get(nums[i]);
                maps.put(nums[i],++count);
            }else{
                int count = 1;
                maps.put(nums[i],count);
            }
        }
        int size = nums.length;
        int result = -1;
        for(Integer ss: maps.keySet()){
            Integer ins = maps.get(ss);
            if(ins > size/2){
                result = ss;
                break;
            }
        }
        return result;
    }

    public int majorityElement01(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
