package com.yuhan.meituan;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/8 20:17
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class Written {
    /**
     * 美团面试：
     * 两个正整数相乘要求不能用long类型接收而且不能让数据溢出了。
     */
    public static void main(String[] args) {
        //提供两个数组表示要相乘的两个整数
        //为了表示出相乘的效果，整数值需要倒着存放在数组里
        int[] arr1 = {1,2,3,4};//45
        int[] arr2 = {1,2,3,4};//89
        //给定一个新数组接收最终结果
        int[] result = new int[arr1.length + arr2.length];

        //遍历两个数组进行相乘
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                //进行相乘
                result[i + j] += arr1[i] * arr2[j];
            }

        }

        //遍历结果数组进行进位
        for (int i = 0; i < result.length - 1; i++) {
            //把数组元素值赋值给新变量
            int temp = result[i];

            //保证每一位数都是个位数
            result[i] = temp % 10;

            //进位
            result[i + 1] += temp / 10;
        }
        //输出结果
        for (int i = result.length - 1; i >= 0; i--) {
            System.out.print(result[i]);
        }
    }

    @Test
    public void test(){
        Map<String,String> maps = new HashMap<>(11);
        maps.put("","");
        System.out.println(maps.size());
    }


}
