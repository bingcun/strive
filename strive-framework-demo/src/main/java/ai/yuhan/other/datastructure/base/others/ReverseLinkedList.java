package ai.yuhan.other.datastructure.base.others;

import org.junit.Test;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/10/11 16:06
 * @Version 1.0
 */
public class ReverseLinkedList {
    static class ListNode {
        private Integer data;
        private ListNode next;
        public ListNode(Integer data) {
            this.data = data;
            next = null;
        }
    }

    @Test
    public void test() {
        ListNode listNode01 = new ListNode(0);
        ListNode listNode02 = new ListNode(1);
        ListNode listNode03 = new ListNode(2);
        ListNode listNode04 = new ListNode(3);

        listNode01.next = listNode02;
        listNode02.next = listNode03;
        listNode03.next = listNode04;
        ListNode listNodeRes = reverseList(listNode01);
    }

    /**
     * 反转链表
     * @param listNode
     * @return
     */
    private ListNode reverseList(ListNode listNode) {
        ListNode head = listNode;
        ListNode tail = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }
        return tail;
    }
}
