package ai.yuhan.other.datastructure.careers.easy;

import org.junit.Test;

/**
 * @description: 缺失数字
 * 题目描述
 * 从0,1,2,...,n这n+1个数中选择n个数，找出这n个数中缺失的那个数，要求O(n)尽可能小
 * 输入: [0,1,2,3,4,5,7]
 * 输出: 6
 *
 * 输入
 * [0,2,3]
 * 输出
 * 1
 * @author: bingcun.chen
 * @Date: 2021/5/12 16:29
 * @Version 1.0
 */
public class NC101 {

    /**
     * 第一种解决方式:通过匹配值进行判断
     * @param a
     * @return
     */
    public int solve01 (int[] a) {
        // write code here
        int size = a.length;
        if(size <= 2)return 0;

        int start = a[0];
        int end = a[a.length - 1];

        for(int i=1;i<=size - 1;i++){
            if(++start!=a[i]){
                return a[i] -1 ;
            }
        }

        if(size != a[size -1]) return size;
        return 0;
    }

    /**
     * 通过角标进行匹配
     * @param a
     * @return
     */
    public int solve02 (int[] a) {
        int size = a.length;
        if(size <= 2)return 0;

        for(int i=0;i<size;i++){
            if(i != a[i]){
                return i;
            }
        }

        if(size != a[size -1]) return size;
        return 0;
    }



    @Test
    public void test01(){
        int[] arr = new int[]{1,2,3};
        System.out.println(solve01(arr));
    }


    @Test
    public void test02(){
        int[] arr = new int[]{0,1,2,3};
        System.out.println(solve01(arr));
    }
}
