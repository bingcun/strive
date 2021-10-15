package ai.yuhan.other.datastructure.juide;

import org.junit.Test;

/**
 * @description: 反转链表
 * @author: bingcun.chen
 * @Date: 2021/8/19 14:37
 * @Version 1.0
 */
public class Test3_3_5 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 反转链表(非双向链表)
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //定义一个后继节点
        ListNode next = null;
        //定义一个前驱节点
        ListNode pre = null;

        while (head != null){
            //存储当前节点的下一个节点
           next = head.next;
           //当前节点的下一个节点指向前驱节点
           head.next = pre;
           //前驱节点引用头节点指针
           pre = head;
           //将之前存储的当前节点的下一个节点给head
           head = next;
        }
        return pre;
    }


    /**
     * 从指定位置反转链表
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
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

        ListNode reverseBetween = reverseBetween(listNode01,1,3);
        System.out.println(reverseBetween);
    }

}
