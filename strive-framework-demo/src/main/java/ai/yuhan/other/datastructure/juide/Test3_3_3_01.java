package ai.yuhan.other.datastructure.juide;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/8/18 17:43
 * @Version 1.0
 */
public class Test3_3_3_01 {

    /**
     * 计算最长子串
     * "abccccdd"
     * @param s
     * @return
     */
    public int longestPalindrome(String s){
        if(s.length() == 0)return 0;
        int count = 0;
        Set<Character> sets = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(!sets.contains(s.charAt(i))){
                sets.add(s.charAt(i));
            }else {
                ++count;
                sets.remove(s.charAt(i));
            }
        }
        return sets.isEmpty() ? count * 2 : count * 2 + 1;
    }

    @Test
    public void test(){
        String ss = "ddcccdd";
        System.out.println(longestPalindrome(ss));
    }

}
