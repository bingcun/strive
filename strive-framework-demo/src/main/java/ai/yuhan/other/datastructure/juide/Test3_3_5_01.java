package ai.yuhan.other.datastructure.juide;

import org.junit.Test;

/**
 * @description: 反转链表
 * @author: bingcun.chen
 * @Date: 2021/8/20 15:44
 * @Version 1.0
 */
public class Test3_3_5_01 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 反转链表
     * @param listNode
     * @return
     */
    public ListNode ReverseList(ListNode listNode){
        ListNode pre = null;
        ListNode next = null;

        while (listNode != null){
            next = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = next;
        }

        return pre;
    }

    @Test
    public void test(){
        ListNode listNode01 = new ListNode(1);
        ListNode listNode02 = new ListNode(2);
        ListNode listNode03 = new ListNode(3);
        ListNode listNode04 = new ListNode(4);
        ListNode listNode05 = new ListNode(5);
        listNode01.next = listNode02;
        listNode02.next = listNode03;
        listNode03.next = listNode04;
        listNode04.next = listNode05;

        ListNode listNode = ReverseList(listNode01);
        System.out.println("sssss");

    }




}
