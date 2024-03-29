package ai.yuhan.other.datastructure.juide;

import org.junit.Test;

import java.util.Stack;

/**
 * @description:
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @author: bingcun.chen
 * @Date: 2021/8/22 22:35
 * @Version 1.0
 */
public class Test3_3_20 {

    //12345 45321
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for(int i = 0; i< pushA.length;i++){
            s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while(!s.empty() && s.peek() == popA[popIndex]){
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }

    @Test
    public void test(){
        int[] array = new int[]{1,2,3,4,5};
        int[] array01 = new int[]{4,5,3,2,1};
        System.out.println(IsPopOrder(array, array01));

    }
}
