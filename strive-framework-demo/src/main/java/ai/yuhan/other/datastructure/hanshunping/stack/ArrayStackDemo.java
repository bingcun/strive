package ai.yuhan.other.datastructure.hanshunping.stack;

import ai.yuhan.demo.test.A;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/10/14 14:19
 * @Version 1.0
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.add(1);
        stack.add(2);
        stack.add(3);

        stack.add(4);

        System.out.println(stack.pop());
        stack.add(5);
        System.out.println(stack.pop());
        System.out.println();


    }


}
class ArrayStack{
    private int[] stack;
    private int maxSize;
    private int top = -1;//表示栈顶

    public ArrayStack(int size){
        this.maxSize = size;
        stack = new int[size];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize -1;
    }

    public void add(int data){
        if(isFull()){
            System.out.println("栈满,不能存储数据");
            return;
        }
        top++;
        stack[top] = data;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空，没有数据~");
        }
        int ints = stack[top];
        top--;
        return ints;
    }

    public void isShow(){
        if(isEmpty()){
            System.out.println("栈空，没有数据~~");
            return;
        }
        for(int i = top;i>=0;i--){
            System.out.printf("stack[%d]=%d\n", i);
        }

    }

}