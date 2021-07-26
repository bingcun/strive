package ai.yuhan.other.datastructure.exercise;

import org.junit.Test;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/7/17 11:53
 * @Version 1.0
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String result = "";
        String[] s1 = s.split(" ");
        for (String s2 : s1) {
            String s3 = swapData(s2, 0, s2.length() - 1);
            result = result + s3 + " ";
        }
        return  result.trim();
    }

    private String swapData(String ss,int left,int right){
        char[] chars = ss.toCharArray();
        while (left < right){
            char ss1 = chars[left];
            chars[left] = chars[right];
            chars[right] = ss1;
            left++;
            right--;
        }
        return new String(chars);
    }

    @Test
    public void test(){
        String ss = "Let's take LeetCode contest";
        System.out.println(reverseWords(ss));

    }


}
