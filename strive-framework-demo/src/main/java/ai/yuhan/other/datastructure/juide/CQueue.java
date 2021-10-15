package ai.yuhan.other.datastructure.juide;

import org.junit.Test;

import java.util.Stack;

/**
 * @description: 用两个栈实现队列
 * @author: bingcun.chen
 * @Date: 2021/8/23 9:26
 * @Version 1.0
 */
public class CQueue {
    private Stack<Integer> stack01;
    private Stack<Integer> stack02;

    public CQueue() {
        stack01 = new Stack<>();
        stack02 = new Stack<>();
    }

    public void appendTail(int value) {
        stack01.push(value);
    }

    public int deleteHead() {
        if(stack02.isEmpty()){
            while (!stack01.isEmpty()){
                stack02.push(stack01.pop());
            }
        }
        return stack02.isEmpty()?-1:stack02.pop();
    }

    public Stack lookAll(){
        return this.stack02;
    }


    @Test
    public void test(){
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);

        cQueue.deleteHead();

        Stack stack = cQueue.lookAll();
        System.out.println("ssssss");


    }


}
