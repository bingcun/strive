package ai.yuhan.demo.datastructure.careers.easy;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: 字符串变形
 * 对于一个给定的字符串，我们需要在线性(也就是O(n))的时间里对它做一些变形。首先这个字符串中包含着一些空格，就像"Hello World"一样，
 * 然后我们要做的是把着个字符串中由空格隔开的单词反序，同时反转每个字符的大小写。比如"Hello World"变形后就变成了"wORLD hELLO"。
 *
 * 输入描述:
 *      给定一个字符串s以及它的长度n(1≤n≤500)
 * 返回值描述:
 *      请返回变形后的字符串。题目保证给定的字符串均由大小写字母和空格构成。
 * 输入:   "This is a sample",16
 * 返回值："SAMPLE A IS tHIS"
 *
 * @author: bingcun.chen
 * @Date: 2021/5/15 16:18
 * @Version 1.0
 */
public class NC89 {

    public String trans(String s, int n) {
        // write code here
        if(n <= 3)return "";

        char[] chars = s.toCharArray();

        Map<Integer,List<Character>> list = new LinkedHashMap<>();
        int count = 0;
        for (int i=0;i<chars.length;i++) {
            if(chars[i]==' '){
                List<Character> lists = new ArrayList<>();
                for(int j = 0;j<i;j++){
                    lists.add(chars[j]);
                }
                list.put(count++, lists);
            }
        }

        Set<Map.Entry<Integer, List<Character>>> entries = list.entrySet();
        List<Character> listCharacter = new ArrayList<>();


        return "";
    }

//     * 输入:   "This is a sample",16
//            * 返回值："SAMPLE A IS tHIS"


    public String change(String s,int n){
        StringBuffer str=new StringBuffer();
        int start=0;
        for (int i = n-1; i >= 0; i--) {
            if(s.charAt(i)==' '){
                str.append(" ");
                start=n-i;
            }else {
                char sss = (char) (s.charAt(i) < 97 ? s.charAt(i) + 32 : s.charAt(i) - 32);
                str.insert(start, sss);
            }
        }
        return str.toString();
    }




    @Test
    public void test01(){
        System.out.println(change("This is a sample", 16));

    }

}
