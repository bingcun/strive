package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

/**
 * @description:
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 * @author: bingcun.chen
 * @Date: 2021/5/24 20:40
 * @Version 1.0
 */
public class offer10 {

    /**
     * 青蛙跳台问题
     * @param n
     * @return
     */
    public int numWays(int n) {
        int[] nums = new int[n+1];
        return getWays(nums,n);
    }

    private int getWays(int[] nums, int n) {
        if(n == 0)return 0;
        if(n == 1)return 1;
        if(n == 2)return 2;
        if(nums[n] != 0)return nums[n];
        nums[n] = (getWays(nums,n-1) + getWays(nums,n -2)) % 1000000007;
        return nums[n];
    }

    /**
     * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/solution/mian-shi-ti-10-ii-qing-wa-tiao-tai-jie-wen-ti-dong/
     * @param n
     * @return
     */
    public int numWays01(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int numWays02(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000_000_007;
        }
        return dp[n];
    }


    @Test
    public void test(){
        System.out.println(numWays02(50));
        System.out.println(numWays01(50));

    }


}
