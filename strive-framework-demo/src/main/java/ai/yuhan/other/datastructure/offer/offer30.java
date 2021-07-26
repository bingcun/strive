package ai.yuhan.other.datastructure.offer;

import java.util.Stack;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/7/10 18:27
 * @Version 1.0
 */
public class offer30 {
    Stack<Integer> A, B;
    public offer30() {
        A = new Stack<>();
        B = new Stack<>();
    }
    public void push(int x) {
        A.add(x);
        if(B.empty() || B.peek() >= x)
            B.add(x);
    }
    public void pop() {
        if(A.pop().equals(B.peek()))
            B.pop();
    }
    public int top() {
        return A.peek();
    }
    public int min() {
        return B.peek();
    }
}
