package ai.yuhan.other.datastructure.tuling;

import org.junit.Test;

/**
 * @description: 斐波那契数列
 * 求取斐波那契数列第N位的值。
 * 斐波那契数列：每一位的值等于他前两位数字之和。前两位固定 0，1,1,2,3,5,8。。。。
 * @author: bingcun.chen
 * @Date: 2021/5/21 10:35
 * @Version 1.0
 */
public class NC010 {

    /**
     * 递归求解
     * @param num
     * @return
     */
    public int fibonacciSequence(int num){
        if(num == 0) return 0;
        if(num == 1) return 1;

        return fibonacciSequence(num - 1) + fibonacciSequence(num - 2);
    }

    /**
     * 暴力递归缺点,当数据量大的时候计算值相当的慢
     */
    @Test
    public void test(){
        System.out.println(fibonacciSequence(40));
    }

    /**
     * 递归优化:存储每一步的结果进来
     * @param n
     * @return
     */
    public int fibonacciSequence01(int n){
        int[] nums = new int[n + 1];
        return recursion(n,nums);
    }

    private int recursion(int n, int[] nums) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        if(nums[n] != 0) return nums[n];

        nums[n] = recursion(n - 1,nums) + recursion(n - 2,nums);
        return nums[n];
    }

    /**
     * 动态规划解决斐波那契数列
     * @param n
     * @return
     */
    public int fibonacciSequence02(int n){
        if(n<2)return n;
        int p = 0,q = 0,r = 1;
        for(int i=2;i<=n;i++){
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }


    @Test
    public void test01(){
        System.out.println(fibonacciSequence01(20));
    }

    @Test
    public void test03(){
        System.out.println(fibonacciSequence02(20));
    }

    /**
     * 双指针迭代
     * @return
     */
    public int iterate(int nums){
        if(nums == 0)return 0;
        if(nums == 1)return 1;

        int low = 0;
        int high = 1;

        for(int i=2;i<=nums;i++){
            int sum = low + high;
            low = high;
            high = sum;
        }
        return high;
    }


    @Test
    public void test02(){
        System.out.println(iterate(30));
    }




}
