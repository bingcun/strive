package ai.yuhan.other.datastructure.juide;

import org.junit.Test;

/**
 * @description: 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author: bingcun.chen
 * @Date: 2021/8/22 17:45
 * @Version 1.0
 */
public class Test3_3_13_01 {

    /**
     * 替换空格
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        String s1 = str.toString();
        char[] chars = s1.toCharArray();

        StringBuffer sb = new StringBuffer();
        for (char aChar : chars) {
            if(aChar == ' '){
                sb.append('%').append('2').append('0');
            }else {
                sb.append(aChar);
            }
        }

        return sb.toString();
    }

    @Test
    public void test(){
        StringBuffer sb01 = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(sb01));
    }



}
