package ai.yuhan.other.datastructure.tuling;

import org.junit.Test;
import org.springframework.data.repository.query.parser.PartTree;

import java.util.Arrays;

/**
 * @description: KMP算法
 * @author: bingcun.chen
 * @Date: 2021/6/6 21:44
 * @Version 1.0
 */
public class NC015 {

    @Test
    public void test(){
        String str1 = "ABCABCAABCABCD";
        String strPattern = "ABCABCC";

        int[] next = new int[strPattern.length()];
        getNext(strPattern.toCharArray(),next);

        int i = search(str1.toCharArray(),strPattern.toCharArray(),next);

        System.out.println(Arrays.toString(next));
        System.out.println(i);
    }


    public int search(char[] str,char[] pattern,int[] next){
        int i = 0;
        int j = 0;

        while (i < str.length && j < pattern.length){
            if(j == -1 || str[i] == pattern[j]){
                i++;
                j++;
            }else {
                j = next[j];
            }

            if(j == pattern.length){
                return i - j;
            }
        }
        return -1;
    }


    public void getNext(char[] pattern,int[] next){
        next[0] = -1;
        int i = 0,j = -1;

        while (i < pattern.length){
            //不匹配 i++ j++
            if(j == -1){
                i++;
                j++;
            }else if(pattern[i] == pattern[j]){
                //匹配 数组前一个值记录KMP值
                i++;
                j++;
                next[i] = j;
            }else {
                //失配 返回当前数组的值 数组没有值返回0 然后在走此处 -1的值给j  i++ j++
                j = next[j];
            }
        }
    }
}
