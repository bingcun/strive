package ai.yuhan.other.datastructure.leetcode;

import org.junit.Test;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/7/19 9:50
 * @Version 1.0
 */
public class leetCode5 {

    //中心扩展法记录最长回文子串
    public String longestPalindrome(String s) {
        String result = "";
        for(int i=0;i<s.length();i++){
            String s1 = palindromeStr(s,i,i);
            String s2 = palindromeStr(s,i,i + 1);

            result = result.length() > s1.length() ? result : s1;
            result = result.length() > s2.length() ? result : s2;
        }

        return result;
    }

    /**
     * 判断是否是回文字符串
     * @param ss
     * @param left
     * @param right
     */
    private String palindromeStr(String ss,int left,int right){
        while (left >= 0 && right < ss.length()){
            if(ss.charAt(left) == ss.charAt(right)){
                left--;
                right++;
            }else {
                break;
            }
        }
        return ss.substring(left + 1,right);
    }

    /**
     *  最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome01(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    @Test
    public void test(){
        String ss = "llabcdcba";
        System.out.println(longestPalindrome01(ss));


    }

}
