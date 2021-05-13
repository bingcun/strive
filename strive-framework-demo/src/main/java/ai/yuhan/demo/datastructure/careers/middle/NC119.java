package ai.yuhan.demo.datastructure.careers.middle;

import ai.yuhan.demo.test.A;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目描述
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
 * <p>
 * 示例1
 * 输入
 * [4,5,1,6,2,7,3,8],4
 * 返回值
 * [1,2,3,4]
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/5/7 9:27
 * @Version 1.0
 */
public class NC119 {

    private int[] TEST_INPUT = new int[]{4, 5, 4, 7, 1, 2, 6, 2, 3};

    /**
     * 解法1: 冒泡排序
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution01(int[] input, int k) {
        //如果数组的长度小于K的大小
        int size = input.length;
        if (k > size && k == 0) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        //原始数组:    [4, 5, 4, 7, 1, 2, 6, 2, 3]
        //第一轮冒泡:  [4, 4, 5, 1, 2, 6, 2, 3, 7]
        //第二轮冒泡:  [4, 4, 1, 2, 5, 2, 3, 6, 7]
        //第三轮冒泡:  [4, 1, 2, 4, 2, 3, 5, 6, 7]
        //第四轮冒泡:  [1, 2, 4, 2, 3, 4, 5, 6, 7]
        //第五轮冒泡:  [1, 2, 2, 3, 4, 4, 5, 6, 7]
        //定义返回的数组
        for (int i = 0; i < input.length -1; i++) {
            for (int j = 0; j < input.length - 1 - i; j++) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
        //原始数组:    [4, 5, 4, 7, 1, 2, 6, 2, 3]
        //第一轮冒泡:  [5, 4, 7, 4, 2, 6, 2, 3, 1]
        //第二轮冒泡:  [5, 7, 4, 4, 6, 2, 3, 2, 1]
        //第三轮冒泡:  [7, 5, 4, 6, 4, 3, 2, 2, 1]
        //第四轮冒泡:  [7, 5, 6, 4, 4, 3, 2, 2, 1]
        //第五轮冒泡:  [7, 6, 5, 4, 4, 3, 2, 2, 1]
//        for (int i = 0; i < input.length -1; i++) {
//            for (int j = 0; j < input.length - 1 - i; j++) {
//                if (input[j] < input[j + 1]) {
//                    int temp = input[j];
//                    input[j] = input[j + 1];
//                    input[j + 1] = temp;
//                }
//            }
//        }
//        for(int i=0;i<k;i++){
//            list.add(input[i]);
//        }
        return list;
    }
    @Test
    public void test01(){
        System.out.println(GetLeastNumbers_Solution01(TEST_INPUT,5));
    }


    /**
     * 解法2:java自带的排序sort
     * 简介:数据量大的时候性能很低
     * @param input
     * @param k
     * @return
     */
    public  ArrayList<Integer> GetLeastNumbers_Solution02(int[] input, int k) {
        int size = input.length;
        if(k>size && k>0){
            return new ArrayList<>();
        }

        ArrayList list = new ArrayList();
        Arrays.sort(input);
        for(int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }


    @Test
    public void test02(){
        System.out.println(GetLeastNumbers_Solution02(TEST_INPUT,5));
    }


    /**
     * 解法3:插入排序
     * 插入排序是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，
     * 为最新元素提供插入空间。
     *
     * 算法描述:
     * 1.一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
     * 2.从第一个元素开始，该元素可以认为已经被排序
     * 3.取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 4.如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 5.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 6.将新元素插入到该位置后
     * 7.重复步骤2~5
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution03(int[] input, int k) {

        if(k <= 0 && k<input.length){
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>();
        //原始数组  [4, 5, 4, 7, 1, 2, 6, 2, 3]
        for(int i=1;i<input.length;i++){
            int temp = input[i]; //temp表示第二个元素  j表示前一个元素
            int j = i - 1;

            //i=4 [4, 4, 5, 7, 1, 2, 6, 2, 3]
            //i=4 j=3 [4, 4, 5, 7, 7, 2, 6, 2, 3]
            //i=4 j=2 [4, 4, 5, 5, 7, 2, 6, 2, 3]
            //i=4 j=1 [4, 4, 4, 5, 7, 2, 6, 2, 3]
            //i=4 j=0


            //判断第一个是否大于第二个元素
            for(;j>=0 && input[j]>temp;j--){
                input[j+1] = input[j];
            }
            input[j+1] = temp;
        }

        System.out.println(Arrays.toString(input) + " insertSort");

        for(int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }

    @Test
    public void test03(){
        GetLeastNumbers_Solution03(TEST_INPUT,4);
    }
}
