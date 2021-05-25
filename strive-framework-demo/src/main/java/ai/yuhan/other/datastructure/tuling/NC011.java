package ai.yuhan.other.datastructure.tuling;

import lombok.Data;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/5/21 13:31
 * @Version 1.0
 */
public class NC011 {
    @Data
    public static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(){}

        public ListNode(int data){
            this.data = data;
            next = null;
        }
    }

    /**
     * 方法1:双向链表法判断是否有环
     * @param head
     * @return
     */
    public boolean hasRing(ListNode head){
        if(head == null || head.next == null)return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast){
            if(fast == null || fast.next == null)return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * hash法判断是否有环
     * @return
     */
    public boolean hasRing02(ListNode head){
        Set<Integer> nodeSet = new HashSet<>();

        while (head != null){
            if(!nodeSet.add(head.data)){
                return true;
            }
            head = head.next;
        }
        return false;
    }


    @Test
    public void test01(){
        ListNode node01 = new ListNode(10);
        ListNode node02 = new ListNode(9);
        ListNode node03 = new ListNode(8);
        ListNode node04 = new ListNode(7);

//        node01.setNext(node02);
//        node02.setNext(node03);
//        node03.setNext(node04);
        node04.setNext(node01);


        System.out.println(hasRing02(node04));


    }


}
