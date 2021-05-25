package ai.yuhan.other.datastructure.tuling;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @description:
 * 最长连续子串,寻找连续字符串的个数
 * @author: bingcun.chen
 * @Date: 2021/5/22 14:46
 * @Version 1.0
 */
public class NC014 {

    /**
     * 贪心算法解决问题
     * @param arr
     * @return
     */
    public int longestStr(int[] arr) {
        int start = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                start++;
            } else {
                start = 0;
            }
            max = Math.max(max, start);
        }
        return max;
    }

    @Test
    public void test() {
        int[] arr = new int[]{1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 2, 1, 1, 0};
        System.out.println(longestStr(arr));
    }

    /**
     * 最长连续子串的个数
     * @return
     */
    public String longestSubStr(String str){

        Set<Character> ss = new LinkedHashSet<>();

        for(int i=0;i<str.length();i++){
           ss.add(str.charAt(i));
        }
        char[] chars = new char[ss.size()];

        final int[] total = {0};
        ss.stream().forEach(n->{
            chars[total[0]] = n;
            total[0]++;
        });

        return new String(chars);
    }

    @Test
    public void test01(){
        System.out.println(longestSubStr("aaaeeeccc"));
    }




}

