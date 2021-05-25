package ai.yuhan.other.datastructure.tuling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

/**
 * @description:
 * 反转链表
 * @author: bingcun.chen
 * @Date: 2021/5/14 10:19
 * @Version 1.0
 */
public class NC001 {

    //ListNode静态内部类
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListNode{
        private int data;
        private ListNode next;
    }

    /**
     * 反转链表-迭代遍历
     * @param head
     * @return
     */
    public ListNode reverseLinkedNode01(ListNode head){
        ListNode next,prev = null;
        //保留原始链表
        ListNode curr = head;

        //迭代判断当前节点是否为空
        while(curr!=null){
            //临时变量存储下一个节点的数据
            next = curr.next;
            //切断当前节点的下一个节点的指向
            curr.next = prev;
            //然后将当前节点给需要返回的节点
            prev = curr;
            //当前节点变成调整过的节点
            curr = next;
        }

        return prev;
    }

    /**
     * 递归方式反转链表
     * @return
     */
    public ListNode reverseLinkedNode02(ListNode head){
        //通过递归的方式找到倒数第二个节点作为出口
        if(head == null || head.next == null){
            return head;
        }
        //递归判断
        ListNode newHead = reverseLinkedNode02(head.next);
        //后一个节点指针指向前一个节点
        head.next.next = head;
        //断开当前节点指向后一个节点的指针
        head.next = null;
        return newHead;
    }


    @Test
    public void test01(){
        ListNode listnode5 = new ListNode(5,null);
        ListNode listnode4 = new ListNode(4,listnode5);
        ListNode listnode3 = new ListNode(3,listnode4);
        ListNode listnode2 = new ListNode(2,listnode3);
        ListNode listnode1 = new ListNode(1,listnode2);
        ListNode listNode = reverseLinkedNode01(listnode1);
        System.out.println(listNode);
    }

    @Test
    public void test02(){
        ListNode listnode5 = new ListNode(5,null);
        ListNode listnode4 = new ListNode(4,listnode5);
        ListNode listnode3 = new ListNode(3,listnode4);
        ListNode listnode2 = new ListNode(2,listnode3);
        ListNode listnode1 = new ListNode(1,listnode2);

        ListNode listNode = reverseLinkedNode02(listnode1);
        System.out.println(listNode);
    }


}
