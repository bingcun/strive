package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 * s = ""
 * 返回 " "
 *
 * @author: bingcun.chen
 * @Date: 2021/5/24 20:16
 * @Version 1.0
 */
public class offer50 {
    public char firstUniqChar(String s) {
        Map<Character,Integer> maps = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if(maps.containsKey(s.charAt(i))){
                Integer temp = maps.get(s.charAt(i));
                maps.put(s.charAt(i),++temp);
            }else {
                maps.put(s.charAt(i),1);
            }
        }

        for(int j=0;j<s.length();j++){
            Integer count = maps.get(s.charAt(j));
            if(count == 1)return s.charAt(j);
        }
        return ' ';
    }

    @Test
    public void test(){
        String ss = "leetcode";
        System.out.println(firstUniqChar(ss));


    }

}
