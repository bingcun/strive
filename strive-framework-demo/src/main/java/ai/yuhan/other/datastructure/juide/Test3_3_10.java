package ai.yuhan.other.datastructure.juide;

import org.junit.Test;

/**
 * @description: 青蛙跳台问题
 * @author: bingcun.chen
 * @Date: 2021/8/22 15:00
 * @Version 1.0
 */
public class Test3_3_10 {

    /**
     * 递归计算超出时间限制
     * @param n
     * @return
     */
    public int numWays(int n) {
        if(n == 0)return 1;
        if(n == 1)return 1;
        if(n == 2)return 2;

        //递推公式 f(n) = f(n -1) + f(n -2)
        return numWays(n -1) + numWays(n - 2);
    }

    /**
     * 青蛙跳台动态规划记录每一个层级的数据
     * @param n
     * @return
     */
    public int numWays01(int n) {
        int[] dp = new int[n + 1];
        return reversion(n,dp);
    }
    public int reversion(int n,int[] dp){
        if(n == 0)return 1;
        if(n == 1)return 1;
        if(n == 2)return 2;
        if(dp[n] != 0)return dp[n];
        dp[n] = reversion(n -1,dp)% 1000000007 + reversion(n - 2,dp)% 1000000007;
        return dp[n] % 1000000007;
    }

    /**
     * 滚动窗口计算值
     * @param n
     * @return
     */
    public int numWays02(int n){
        if(n == 0)return 1;
        if(n == 1)return 1;
        if(n == 2)return 2;

        int p = 1,q = 2,r = 0;
        for(int i = 3;i<= n;i++){
            r = (p + q) % 1000000007;
            p = q % 1000000007;
            q = r % 1000000007;
        }
        return r;
    }

    @Test
    public void test(){
        System.out.println(numWays02(48));
    }
}
