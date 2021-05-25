package ai.yuhan.other.datastructure.base.others;

import java.util.Stack;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/19 10:42
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class TwoStack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int data){
        stack1.push(data);
    }

    public int pop(){
        if(stack2.size()<=0){
            while (stack1.size()!=0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
