package ai.yuhan.other.datastructure.juide;

import java.util.Stack;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/8/22 22:02
 * @Version 1.0
 */
public class Test3_3_19 {
    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();

    public Test3_3_19() {}

    public void appendTail(int value) {
        stack1.push(value);
    }

    //stack01 和 stack02 01 正常存放 02辅助 执行删除操作时 重新push一遍变为正确顺序。
    public int deleteHead() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) stack2.push(stack1.pop());
        }
        return stack2.isEmpty()? -1:stack2.pop();
    }


}
