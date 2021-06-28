package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: bingcun.chen
 * @Date: 2021/6/27 21:55
 * @Version 1.0
 */
public class offer53_01 {
    /**
     * jdk8 算法
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        long count = Arrays.stream(nums).filter(ns -> ns == target).count();
        return Integer.parseInt(String.valueOf(count));
    }

    /**
     * HashMap方式
     *
     * @param nums
     * @param target
     * @return
     */
    public int search01(int[] nums, int target) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(nums[i])) {
                int temp = maps.get(nums[i]);
                maps.put(nums[i], ++temp);
            }else {
                maps.put(nums[i], 1);
            }
        }
        int result = maps.get(target) == null ? 0 : maps.get(target);
        return result;
    }

    /**
     * 解法三 二分查找法
     * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/solution/mian-shi-ti-53-i-zai-pai-xu-shu-zu-zhong-cha-zha-5/
     * @param nums
     * @param target
     * @return
     */
    public int search03(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }
    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }


    @Test
    public void test(){
        int[] nums = new int[]{5,7,7,8,8,10};
        System.out.println(search01(nums, 8));
    }
}
