package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/8/6 9:38
 * @Version 1.0
 */
public class offer56_1 {
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    @Test
    public void test(){
        int[] nums = new int[]{4,1,4,6};
        int[] ints = singleNumbers(nums);
        System.out.println(ints);
        int[] arr = new int[1];
        arr[0] = 1;
        System.out.println(arr);
    }

    public int singleNumber(int[] nums) {
        int size = nums.length;
        Arrays.sort(nums);
        if(nums[0] != nums[1])return nums[0];
        if(nums[size -2] != nums[size - 1]) return nums[size - 1];

        for(int i=1;i<size;i++){
            if(nums[i] != nums[i-1] && nums[i] != nums[i+1]){
                return nums[i];
            }
        }

        return 0;
    }


}
