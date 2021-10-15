package ai.yuhan.other.datastructure.juide;

import org.junit.Test;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/8/19 10:45
 * @Version 1.0
 */
public class Test3_3_3_03 {
    private int index, len;

    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        for (int i = 0; i < s.length() - 1; i++) {
            //判断奇数的回文序列和偶数的回文序列的长度
            PalindromeHelper(s, i, i);
            PalindromeHelper(s, i, i + 1);
        }
        return s.substring(index, index + len);
    }

    public void PalindromeHelper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (len < r - l - 1) {
            index = l + 1;
            len = r - l - 1;
        }
    }

    @Test
    public void test(){
        String ss = "baabd";
        System.out.println(longestPalindrome(ss));
    }

}
