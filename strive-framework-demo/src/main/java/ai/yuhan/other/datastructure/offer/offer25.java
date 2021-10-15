package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

/**
 * @description:
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @author: bingcun.chen
 * @Date: 2021/6/27 11:06
 * @Version 1.0
 */
public class offer25 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 迭代比较合并两个链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNodeResult = new ListNode(0), curr = listNodeResult;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = l1 == null ? l2 : l1;
        return listNodeResult.next;
    }

    public ListNode mergeTwoLists01(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 != null ? l1 : l2;
        }
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    @Test
    public void test(){
        ListNode l101 = new ListNode(1);
        ListNode l102 = new ListNode(2);
        ListNode l104 = new ListNode(4);
        l101.next = l102;
        l102.next = l104;

        ListNode l201 = new ListNode(1);
        ListNode l203 = new ListNode(3);
        ListNode l204 = new ListNode(4);

        l201.next = l203;
        l203.next = l204;

        ListNode listNode = mergeTwoLists01(l101, l201);
        System.out.println(listNode);
    }
}
