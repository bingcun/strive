package ai.yuhan.demo.datastructure.careers.easy;

import org.junit.Test;

/**
 * @description:
 * 假设你有一个数组，其中第 i 个元素是股票在第 i 天的价格。
 * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
 *
 * 输入 [1,4,2]
 * 输出 3
 *
 * 输入 [2,4,1]
 * 输出 2
 * @author: bingcun.chen
 * @Date: 2021/5/12 17:24
 * @Version 1.0
 */
public class NC47 {


    /**
     * 动态规划实现暂存阶段数据
     * @param prices
     * @return
     */
    public int maxProfit (int[] prices) {
        // write code here
        if (prices == null || prices.length == 0)
            return 0;
        //初始化
        int length = prices.length;
        int[][] dp = new int[length][2];
        //边界条件
        dp[0][0]= 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            //递推公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        //毋庸置疑，最后肯定是手里没持有股票利润才会最大，也就是卖出去了
        return dp[length - 1][0];
    }

    @Test
    public void test01(){
        int[] arr = new int[]{1,4,2,5,6,7,8,10};
        System.out.println(maxProfit(arr));
    }
}
