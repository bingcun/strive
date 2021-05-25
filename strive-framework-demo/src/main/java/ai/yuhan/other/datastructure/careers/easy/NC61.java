package ai.yuhan.other.datastructure.careers.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 两数之和
 * 题目描述:
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解
 * 例如：
 * 给出的数组为 {20, 70, 110, 150},目标值为90
 * 输出 index1=1, index2=2
 *
 *
 * @author: bingcun.chen
 * @Date: 2021/5/9 21:25
 * @Version 1.0
 */
public class NC61 {

    private int[]numbers = new int[]{3,2,4};


    /**
     * 解法1:利用HashMap的containKey特性来解题
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum01 (int[] numbers, int target) {
        //numbers:[12, 34, 4, 6, 7, 4, 3];   target=11;   Map=new HashMap();
        //第一轮:
        // temp = 12; target = 11;
        // maps.containsKey(-1)false;
        // maps(12,1);
        //第二轮:
        //temp = 34; target = 11;
        //maps.containKey(-23)false;
        //maps(12,1)
        //maps(34,2)
        //第三轮:
        //temp = 4; target = 11;
        //maps.containKey(7)false;
        //maps(12,1)
        //maps(34,2)
        //maps(4,3)
        //第四轮:
        //temp = 6; target = 11;
        //maps.containKey(5)false;
        //maps(12,1)
        //maps(34,2)
        //maps(4,3)
        //maps(6,4)
        //第五轮:
        //temp = 7; target = 11;
        //maps.containKey(4)true;
        //maps(12,1)
        //maps(34,2)
        //maps(4,3)
        //maps(6,4)
        //注意:放入HashMap里面的数值是无序的因为里面是对Key求HashCode
        int[] result = new int[2];
        Map<Integer,Integer> maps = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            int temp = numbers[i];
            if(maps.containsKey(target - temp)){
                result[0] = maps.get(target - temp) + 1;
                result[1] = i + 1;
                return result;
            }
            maps.put(temp,i);
        }
        return new int[0];
    }

    @Test
    public void test01(){
        Arrays.stream(twoSum01(numbers, 6)).forEach(System.out::println);
    }



}
