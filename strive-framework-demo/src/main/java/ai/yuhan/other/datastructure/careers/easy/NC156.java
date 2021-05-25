package ai.yuhan.other.datastructure.careers.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description: 数组中只出现一次的数(其他数出现K次)
 * 题目描述
 * 给定一个整型数组 arrarr 和一个整数 k(k>1)k(k>1)。
 * 已知 arrarr 中只有 1 个数出现一次，其他的数都出现 k 次。
 * 请返回只出现了 1 次的数。
 *
 * 输入
 * [5,4,1,1,5,1,5],3
 *
 * 返回值
 * 4
 * @author: bingcun.chen
 * @Date: 2021/5/17 15:51
 * @Version 1.0
 */
public class NC156 {

    /**
     * 计算数组中只出现一次的数
     * @param arr
     * @param k
     * @return
     */
    public int foundOnceNumber (int[] arr, int k) {
        // write code here
        if(arr.length <= k)return -1;

        Map<Integer,Integer> maps = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(maps.containsKey(arr[i])){
                int temp = maps.get(arr[i]);
                maps.put(arr[i],++temp);
            }else{
                maps.put(arr[i],1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = maps.entrySet();
        for(Map.Entry<Integer, Integer> entry:entries){
            if(entry.getValue()==1)return entry.getKey();
        }
        return -1;
    }

    @Test
    public void test01(){
        int[] arr = new int[]{5,4,1,1,5,1,5};
        System.out.println(foundOnceNumber(arr, 3));
    }

}
