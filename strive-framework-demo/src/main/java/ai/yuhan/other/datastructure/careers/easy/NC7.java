package ai.yuhan.other.datastructure.careers.easy;

import org.junit.Test;

/**
 * @description: 股票(一次交易)
 * 题目描述
 * 假设你有一个数组，其中第\ i i 个元素是股票在第\ i i 天的价格。
 * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
 * 输入:[1,4,2]
 * 输出:3
 *
 * 输入:[2,4,1]
 * 输出:2
 *
 * @author: bingcun.chen
 * @Date: 2021/5/17 18:32
 * @Version 1.0
 */
public class NC7 {

    /**
     * 动态规划方案确认最大收益
     * @param prices
     * @return
     */
    public int maxProfit (int[] prices) {
        // write code here


        return 0;
    }

    /**
     * 通过前一个数据和后一个数据作比较
     * @param prices
     * @return
     */
    public int maxProfit01(int[] prices){
        if(prices == null || prices.length==0){
            return 0;
        }
        //初始化数据
        int max = 0;
        int min = prices[0];

        //准备: min=1,max=0
        //第一波:min=0,max=1
        //第二波:min=1,max=3
        //第三波:min=1,max=3

        //递归公式
        for(int i=0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            max = Math.max(max,prices[i] - min);
        }
        return max;
    }

    /**
     * 动态规划解决数据问题
     * @param prices
     * @return
     */
    public int maxProfit02(int[] prices){
        if (prices == null || prices.length == 0) return 0;
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
    public void test(){
        int[] array = new int[]{1,4,2};
        System.out.println(maxProfit01(array));
    }


}
