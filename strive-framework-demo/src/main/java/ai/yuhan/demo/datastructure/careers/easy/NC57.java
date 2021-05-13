package ai.yuhan.demo.datastructure.careers.easy;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description:
 * 题目描述
 * 将给出的32位整数x翻转。
 * 例1:x=123，返回321
 * 例2:x=-123，返回-321
 *
 * 你有注意到翻转后的整数可能溢出吗？因为给出的是32位整数，则其数值范围为[−2^{31}, 2^{31} − 1][−231,231−1]。翻转可能会导致溢出，如果反转后的结果会溢出就返回 0。
 * @author: bingcun.chen
 * @Date: 2021/5/11 22:25
 * @Version 1.0
 */
public class NC57 {


    /**
     * 实现思路:通过栈实现将输入的数据进行反转,前提判断出来正负号然后负数要增加一个填充
     * @param x
     * @return
     */
    public int reverse (int x) {
        Stack<Character> queues = new Stack<>();
        StringBuilder resultStr = new StringBuilder();
        Integer max = 0;

        // write code here
        String ss = String.valueOf(x);
        if(x < 0){
            char[] chars = ss.toCharArray();

            //获取运算符号
            char aChar = chars[0];
            for(int i=1;i<=chars.length-1;i++){
                queues.add(chars[i]);
            }
            char[] charArr = new char[queues.size() + 1];
            for(int i=1;i<=charArr.length -1 ;i++){
                charArr[i] = queues.pop();

            }
            charArr[0] = aChar;
            String ss1 = new String(charArr);

            try {
                max = Integer.valueOf(ss1);
            }catch (Exception e){
                return 0;
            }
        }else {
            char[] chars = ss.toCharArray();

            for(int i=0;i<=chars.length;i++){
                queues.add(chars[i]);
            }
            char[] charArr = new char[queues.size() + 1];
            for(int i=0;i<=charArr.length ;i++){
                charArr[i] = queues.pop();

            }
            String ss1 = new String(charArr);

            try {
                max = Integer.valueOf(ss1);
            }catch (Exception e){
                return 0;
            }
        }
        return max;
    }

    @Test
    public void test01(){
        System.out.println(reverse(-12345999));
    }


}
