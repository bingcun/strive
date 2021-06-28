package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

/**
 * @description: 输入两个链表，找出它们的第一个公共节点。
 * <p>
 * 如下面的两个链表：
 * @author: bingcun.chen
 * @Date: 2021/6/27 20:59
 * @Version 1.0
 */
public class offer52 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;
        while (h1 != h2) {

            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }

        return h1;
    }

    @Test
    public void test(){
        ListNode listNode00 = new ListNode(4);
        ListNode listNode01 = new ListNode(1);
        //公共部分
        ListNode listNode02 = new ListNode(8);
        ListNode listNode03 = new ListNode(4);
        ListNode listNode04 = new ListNode(5);

        listNode00.next = listNode01;
        listNode01.next = listNode02;
        listNode02.next = listNode03;
        listNode03.next = listNode04;

        ListNode listNode05 = new ListNode(5);
        ListNode listNode06 = new ListNode(0);
        ListNode listNode07 = new ListNode(1);

        listNode05.next = listNode06;
        listNode06.next = listNode07;
        listNode07.next = listNode02;


        ListNode intersectionNode = getIntersectionNode(listNode00, listNode05);
        System.out.println();

        Map<Integer,Integer> maps = new HashMap<>();

        maps.put(123,12);
        for(Integer ss: maps.keySet()){
            Integer integer = maps.get(ss);
        }

        System.out.println();
    }

}
