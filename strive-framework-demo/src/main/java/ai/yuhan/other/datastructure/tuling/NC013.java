package ai.yuhan.other.datastructure.tuling;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * 合并两个数组,假设nums1和nums2是有序的,nums1的长度假设是足够长的
 * @author: bingcun.chen
 * @Date: 2021/5/22 12:04
 * @Version 1.0
 */
public class NC013 {

    /**
     * 合并nums1到nums2里面,利用jdk自带的方法进行拷贝合并数据
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public int[] merge(int[] nums1,int m,int[] nums2,int n){
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
        return nums1;
    }

    /**
     * //todo 完善后续两种算法
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public int[] merge2(int[] nums1,int m,int[] nums2,int n){
       int[] result = new int[nums1.length];
       return nums1;
    }


    @Test
    public void test01(){
        int nums1[] = new int[]{1,3,5,7,9,0,0,0,0,0};
        int nums2[] = new int[]{2,4,6,8,10};
        int m = nums1.length;
        int n = nums2.length;

        int[] merge = merge(nums1, 5, nums2, n);
        Arrays.stream(merge).forEach(System.out::print);
    }
}
