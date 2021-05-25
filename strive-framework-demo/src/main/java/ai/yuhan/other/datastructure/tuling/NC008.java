package ai.yuhan.other.datastructure.tuling;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 给定一个数组,满足两个数相加之和等于target
 * @author: bingcun.chen
 * @Date: 2021/5/19 22:12
 * @Version 1.0
 */
public class NC008 {


    public int[] findArrIndex(int[] nums,int target){
        int[] result = new int[2];
        if(nums.length == 2) {
            result[0] = 0;
            result[1] = 1;
            return result;
        }

        if(nums.length == 0) return null;

        Map<Integer,Integer> maps = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(maps.containsKey(nums[i])){
                result[0] = maps.get(nums[i]);
                result[1] = i;
                return result;
            }else{
                maps.put(target-nums[i],i);
            }
        }
        return null;
    }

    @Test
    public void test(){
        int[] arr = new int[]{1,2,3,4,5,6};

        int[] arrIndex = findArrIndex(arr, 10);

        System.out.println(arrIndex);

    }

}
