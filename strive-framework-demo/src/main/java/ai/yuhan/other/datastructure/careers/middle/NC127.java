package ai.yuhan.other.datastructure.careers.middle;

import java.util.Locale;
import java.util.Scanner;

/**
 * @description: 最长公共子串
 * 输入：
 * "1AB2345CD","12345EF"
 * 复制
 * 返回值：
 * "2345"
 * @author: bingcun.chen
 * @Date: 2021/6/5 22:32
 * @Version 1.0
 */
public class NC127 {
    /**
     * 动态规划样例
     * @param str1
     * @param str2
     * @return
     */
    public String LCS(String str1, String str2) {
        // write code here
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int max = 0, index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (max < dp[i + 1][j + 1]) {
                        max = dp[i + 1][j + 1];
                        index = i + 1;
                    }
                }
            }
        }
        return max == 0 ? "-1" : str1.substring(index - max, index);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().toUpperCase();
        System.out.println(str);

        String target = in.next().toUpperCase();
        System.out.println(target);
    }


}
