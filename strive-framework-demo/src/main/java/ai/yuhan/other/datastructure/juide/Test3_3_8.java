package ai.yuhan.other.datastructure.juide;

import jdk.nashorn.internal.ir.CaseNode;
import org.junit.Test;

/**
 * @description: 合并两个链表
 * @author: bingcun.chen
 * @Date: 2021/8/20 17:59
 * @Version 1.0
 */
public class Test3_3_8 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 合并两个排序链表  比较并合并链表
     * 4->6->8->10
     * 2->3->6->8
     * @param l1
     * @param l2
     * @return
     */
    public ListNode Merge(ListNode l1,ListNode l2){
        ListNode list = new ListNode(-1),curr = list;

        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;

        return list.next;
    }

    /**
     * 递归合并链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode Merge01(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        if(l1.val <= l2.val){
            l1.next = Merge01(l1.next,l2);
            return l1;
        }else {
            l2.next = Merge01(l1,l2.next);
            return l2;
        }
    }




    @Test
    public void test(){
        ListNode listNode01 = new ListNode(1);
        ListNode listNode02 = new ListNode(2);
        ListNode listNode03 = new ListNode(3);

        listNode01.next = listNode02;
        listNode02.next = listNode03;

        ListNode listNode04 = new ListNode(1);
        ListNode listNode05 = new ListNode(3);
        ListNode listNode06 = new ListNode(4);

        listNode04.next= listNode05;
        listNode05.next = listNode06;

        ListNode merge = Merge01(listNode01, listNode04);
        System.out.println("ssss");
    }
}
