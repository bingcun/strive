package ai.yuhan.demo.datastructure.careers.middle;

import org.junit.Test;

/**
 * @description:最长回文子串 题目描述
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 * <p>
 * 输入
 * "abc1234321ab",12
 * 输出 7
 * @author: bingcun.chen
 * @Date: 2021/5/13 15:00
 * @Version 1.0
 */
public class NC17 {

//1.回文子串的个数
//2.最长回文子串
//3.最长不连续的回文子串

    /**
     * 动态规划计算回文字符串的长度
     *
     * @param A
     * @param n
     * @return
     */
    public int getLongestPalindrome01(String A, int n) {
        // write code here
        //边界条件判断
        if (n < 2)
            return A.length();
        //start表示最长回文串开始的位置，
        //maxLen表示最长回文串的长度
        int maxLen = 1;
        boolean[][] dp = new boolean[n][n];
        for (int right = 1; right < n; right++) {
            for (int left = 0; left < right; left++) {
                //如果两种字符不相同，肯定不能构成回文子串
                if (A.charAt(left) != A.charAt(right))
                    continue;

                //下面是s.charAt(left)和s.charAt(right)两个
                //字符相同情况下的判断
                //如果只有一个字符，肯定是回文子串
                if (right == left) {
                    dp[left][right] = true;
                } else if (right - left <= 2) {
                    //类似于"aa"和"aba"，也是回文子串
                    dp[left][right] = true;
                } else {
                    //类似于"a******a"，要判断他是否是回文子串，只需要
                    //判断"******"是否是回文子串即可
                    dp[left][right] = dp[left + 1][right - 1];
                }
                //如果字符串从left到right是回文子串，只需要保存最长的即可
                if (dp[left][right] && right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                }
            }
        }
        //最长的回文子串
        return maxLen;
    }

    @Test
    public void test01() {
        System.out.println(getLongestPalindrome01("abc1234321ab", 12));
    }


    /**
     * 暴力匹配数据
     * @param s
     * @return
     */
    public String longestPalindrome02(String s) {
        if (s.length() < 2)
            return s;
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i; j < s.length(); j++) {
                //截取所有子串，然后在逐个判断是否是回文的
                if (isPalindrome(s, i, j)) {
                    if (maxLen < j - i + 1) {
                        start = i;
                        maxLen = j - i + 1;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    //判断是否是回文串
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    @Test
    public void test02(){
        System.out.println(longestPalindrome02("abc1234321ab"));


    }

}
