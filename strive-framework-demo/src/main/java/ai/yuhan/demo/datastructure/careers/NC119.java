package ai.yuhan.demo.datastructure.careers;

import org.junit.Test;

import java.util.ArrayList;

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
     * 解法1: 冒泡排序按从小到大的顺序排列,然后取值K个最小的数
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
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
        System.out.println(GetLeastNumbers_Solution(TEST_INPUT,5));
    }


    //定义解法2:









}
