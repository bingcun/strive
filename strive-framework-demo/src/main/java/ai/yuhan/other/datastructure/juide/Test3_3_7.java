package ai.yuhan.other.datastructure.juide;

import org.junit.Test;

/**
 * @description: 删除链表的倒数第K个节点
 * @author: bingcun.chen
 * @Date: 2021/8/20 16:11
 * @Version 1.0
 */
public class Test3_3_7 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    /**
     * 1->2->3->4->5->6
     * 删除链表的倒数第N个节点 循环两次计算
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode curr = head;
        int size = 0;
        while (curr != null){
            ++size;
            curr = curr.next;
        }
        if(size == 1)return head.next;
        if(size == 2 && n == 1){
            head.next = null;
            return head;
        }
        int dual = 0;
        if(n == size){
            dual = size - n;
        }else {
            dual = size - n  - 1;
        }
        curr = head;
        for(int i = 0;i < size;i++){
            if(dual == i && dual == size - n){
                return head.next;
            }else if(dual == i && dual == size - 2){
                curr.next = null;
                break;
            }else if(dual == i){
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }
        return head;
    }


    /**
     * 双指针法删除链表的倒数第N个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd01(ListNode head, int n){
        ListNode headDummy = new ListNode(-1);
        headDummy.next = head;

        ListNode fast = head;
        ListNode slow = headDummy;

        for(int i =0;i<n;i++){
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        if(slow != null && slow.next != null){
            slow.next = slow.next.next;
        }

        return headDummy.next;
    }

    @Test
    public void test(){
        ListNode listNode01 = new ListNode(1);
        ListNode listNode02 = new ListNode(2);
        ListNode listNode03 = new ListNode(3);
//        ListNode listNode04 = new ListNode(4);
//        ListNode listNode05 = new ListNode(5);

        listNode01.next = listNode02;
        listNode02.next = listNode03;
//        listNode03.next = listNode04;
//        listNode04.next = listNode05;

        ListNode listNode = removeNthFromEnd01(listNode01, 2);
        System.out.println("ssss");

    }

}
