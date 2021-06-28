package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

/**
 * @description: 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: " hello world! "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good  example"
 * 输出:"example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * @Date: 2021/6/28 11:17
 * @Version 1.0
 */
public class offer58_01 {

    /**
     * 反转字符串
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String trim = s.trim(); //删除首尾空格
        int j = trim.length() - 1,i = j;
        StringBuffer sb = new StringBuffer();
        while (i >= 0){
           while (i >= 0 && trim.charAt(i) != ' ')i--; //搜索首个空格
           sb.append(trim.substring(i + 1,j + 1) + " "); //添加单词
           while (i >= 0 && trim.charAt(i) == ' ')i--; //j指向下个单词的尾字符
           j = i;
        }
        return sb.toString().trim();//转化为字符串返回
    }

    @Test
    public void test(){
        String ss = " hello world! ";
        String trim = ss.trim();
        System.out.println(reverseWords(trim));
    }

}
