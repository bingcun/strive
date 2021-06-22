package ai.yuhan.other.datastructure.offer;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/5/27 12:29
 * @Version 1.0
 */
public class offer62 {

    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            list.add(i);
        }
        int i = 0;
        while (n > 1){
            i = (i + m - 1) % n;
            list.remove(i);
            n--;
        }
        return list.get(0);
    }

    @Test
    public void test(){
        System.out.println(lastRemaining(5, 3));
        String s = "";
    }

    public String test01(String s){
        char[] chars = s.toCharArray();
        char[] result = new char[s.length() * 3];

        int size = 0;
        for(int i=0;i<chars.length;i++){
            char cs = chars[i];
            if(cs == ' '){
                result[size++] = '%';
                result[size++] = '2';
                result[size++] = '0';
            }else {
                result[size++] = cs;
            }
        }

        return new String(result,0,size);
    }

}
