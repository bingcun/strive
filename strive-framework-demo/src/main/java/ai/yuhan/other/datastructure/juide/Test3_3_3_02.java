package ai.yuhan.other.datastructure.juide;

import org.apache.logging.log4j.util.Strings;
import org.junit.Test;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/8/19 10:05
 * @Version 1.0
 */
public class Test3_3_3_02 {


    /**
     * 判断字符串是否是回文子串
     * @param s
     * @return
     */
    public boolean isPalindrome(String s){
        if(s.length()==0)return true;
        int l = 0,r = s.length() - 1;
        while (l < r){
           if(!Character.isLetterOrDigit(s.charAt(l))){
               l++;
           }else if(!Character.isLetterOrDigit(s.charAt(r))){
               r--;
           }else {
               if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                   return false;
               }
                   l++;
                   r--;
           }
        }
        return true;
    }

    @Test
    public void test(){
        String ss = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(ss));
    }
}
