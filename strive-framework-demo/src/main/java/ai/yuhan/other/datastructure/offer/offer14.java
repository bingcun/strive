package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/7/18 18:22
 * @Version 1.0
 */
public class offer14 {
    public int cuttingRope(int n) {
        if(n==2)return 1;
        if(n==3)return 2;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i=4;i<=n;i++){
            dp[i] = Math.max(dp[i-2] * 2,dp[i-3] * 3);
        }
        return dp[n];
    }

    @Test
    public void test(){
        System.out.println(cuttingRope(6));
    }
}
