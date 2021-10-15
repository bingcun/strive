package ai.yuhan.other.datastructure.hanshunping.stack;

import javax.swing.text.html.HTMLDocument;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/10/14 15:31
 * @Version 1.0
 */
public class SingleLinkedStackDemo {
    public static void main(String[] args) {
        SingleLinkedStack singleLinkedStack = new SingleLinkedStack(3);
        singleLinkedStack.add(1);
        singleLinkedStack.add(2);
        singleLinkedStack.add(3);

        System.out.println(singleLinkedStack.pop());
        singleLinkedStack.add(4);
        System.out.println("2122");
        singleLinkedStack.add(5);

        singleLinkedStack.list();


    }

}
class SingleLinkedStack{
    private int top = -1;
    private int maxSize;
    private ListNode head;


    public SingleLinkedStack(int size){
        this.maxSize = size;
        head = new ListNode(-1);
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }


    public void add(int data){
        if(isFull()){
            System.out.println("栈已满,不能添加元素");
            return;
        }
        ListNode dataNode = new ListNode(data);
        dataNode.next = head;
        head = dataNode;
        top++;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空不能添加元素");
        }
        ListNode temp = head;
        head = head.next;
        top--;
        return temp.data;
    }

    public void list(){
        ListNode temp = head;
        while (temp.next != null){
            System.out.printf("当前出栈的元素是%d\n",temp.data);
            temp = temp.next;
        }
    }


}
class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
    }
}