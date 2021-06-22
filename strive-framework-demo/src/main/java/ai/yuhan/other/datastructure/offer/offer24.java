package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

import java.util.Stack;

/**
 * @description: 反转链表
 * @author: bingcun.chen
 * @Date: 2021/6/4 22:31
 * @Version 1.0
 */
public class offer24 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /**
     * 反转链表 第一种双向链表法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode pre = null,next = null;

        while (curr != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 反转链表第二种解法
     * @param head
     * @return
     */
    public ListNode reverseList02(ListNode head){
       //3.递归出口找到最后一个节点 然后从递归方法之后开始执行
        if(head == null || head.next == null){
           return head;
       }
       ListNode next = reverseList02(head.next);
       //1.表示当前节点的下一个节点指向当前节点  2.指向下一个节点的值指向null
       head.next.next = head;
       head.next = null;
       return next;
    }

    /**
     * 反转链表:借助栈实现反转
     */
    public ListNode reverseList03(ListNode head) {
        if (head == null) return head;
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            stack.push(head);
            head = head.next;
        }
        //吐出来一个元素方便指向下一个元素
        ListNode newHead = stack.pop();
        ListNode tailNode = newHead;
        while (!stack.isEmpty()){
            ListNode cur =  stack.pop();
            tailNode.next = cur;
            tailNode = cur;
        }
        tailNode.next = null;
        return newHead;
    }

    @Test
    public void test(){
        ListNode listNode01 = new ListNode(1);
        ListNode listNode02 = new ListNode(2);
        ListNode listNode03 = new ListNode(3);
        ListNode listNode04 = new ListNode(4);

        listNode01.next = listNode02;
        listNode02.next = listNode03;
        listNode03.next = listNode04;

        ListNode listNode = reverseList02(listNode01);
        System.out.println();

    }
}
