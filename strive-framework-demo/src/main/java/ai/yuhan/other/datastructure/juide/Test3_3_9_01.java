package ai.yuhan.other.datastructure.juide;

import org.junit.Test;

/**
 * @description: 斐波那契数列
 * @author: bingcun.chen
 * @Date: 2021/8/22 13:59
 * @Version 1.0
 */
public class Test3_3_9_01 {

    /**
     * 斐波那契数列 递归方式计算(缺点时间较长)
     * @param n
     * @return
     */
    public int fib(int n) {
        if(n == 0)return 0;
        if(n == 1)return 1;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 递归升级版本
     * @param n
     * @return
     */
    public int fib01(int n){
        int[] dp = new int[n + 1];
        return recursion(n,dp);
    }
    private int recursion(int n,int[] dp) {
        if(n == 0)return 0;
        if(n == 1)return 1;
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = recursion(n -1 , dp) + recursion(n -2,dp);
        return dp[n];
    }

    /**
     * 迭代的方式计算斐波那契数列
     * 抖动窗口迭代计算
     * @param n
     * @return
     */
    public int fib02(int n){
        if(n < 0)return 0;
        if(n == 1 || n == 2)return 1;
        int p = 1,q = 1,r = 0;
        for(int i = 3;i<=n;i++){
            r = p + q;
            p = q;
            q = r;
        }
        return r;
    }

    @Test
    public void test(){
        System.out.println(fib02(20));
    }

}
