package ai.yuhan.other.datastructure.tuling;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;

import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/6/7 9:05
 * @Version 1.0
 */
public class KMP {

    @Test
    public void test(){
        String str1 = "ABCABCAABCABCD";
        String strPattern = "ABCABCD";
        int[] next = new int[strPattern.length()];

        getNext(strPattern.toCharArray(),next);
        int size = search(str1.toCharArray(),strPattern.toCharArray(),next);

        System.out.println(Arrays.toString(next));
        System.out.println(size);
    }

    public int search(char[] str,char[] pattern,int[] next){
        int i = 0,j = 0;

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
            if(j == -1){
                i++;
                j++;
            }else if(pattern[i] == pattern[j]){
                i++;
                j++;
                next[i] = j;
            }else {
                j = next[j];
            }
        }
    }

}
