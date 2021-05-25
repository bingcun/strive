package ai.yuhan.other.datastructure.tuling;

import org.junit.Test;

/**
 * @description: 素数：只能被1和自身整除的数，0、1除外
 * @author: bingcun.chen
 * @Date: 2021/5/14 13:47
 * @Version 1.0
 */
public class NC002 {


    /**
     * 统计N以内的素数,暴力破解法
     * 首先统计
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n < 2) return 0;

        int count = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= i; j++) {
                if ((i % j) == 0 && i != j) {
                    break;
                }
                if (i == j) count++;
            }
        }
        return count;
    }

    /**
     * 埃式筛选
     *
     * @param n
     * @return
     */
    public int countPrimes01(int n) {
        boolean[] flag = new boolean[n];//false 表示素数
        // Arrays.fill(flag,true);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!flag[i]) {
                count++;
            }
            for (int j = i * i; j < n; j += i) {
                flag[j] = true;
            }
        }
        return count;
    }

    public int countSubstrings(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int count = 0;//回文串的数量
        //字符串从后往前判断
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                //如果i和j指向的字符不一样，那么dp[i][j]就
                //不能构成回文字符串
                if (s.charAt(i) != s.charAt(j))
                    continue;
                dp[i][j] = j - i <= 2 || dp[i + 1][j - 1];
                //如果从i到j能构成回文串，count就加1
                if (dp[i][j])
                    count++;
            }
        }
        return count;
    }


    @Test
    public void test02() {
        System.out.println(countPrimes01(100));
    }

    @Test
    public void test01() {
        System.out.println(countPrimes(100));

    }

    @Test
    public void test03(){
        System.out.println(countSubstrings("SSS"));
    }



}
