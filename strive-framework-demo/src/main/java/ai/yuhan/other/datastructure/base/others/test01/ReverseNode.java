package ai.yuhan.other.datastructure.base.others.test01;

import org.junit.Test;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/7 10:16
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class ReverseNode {

    ListNode pre = null;
    ListNode next = null;


    public void addNode(int data){
        ListNode node = new ListNode(data);

        node.next = pre;

        pre = node;
    }


    /**
     * 反转链表
     * 思路:
     *    1.循环链表
     *    2.拿到当前链表的头一个节点
     *    3.往后每次循环出来的值都放在当前节点的前面
     *
     * @param head
     * @return
     */
    public ListNode reverseNode(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        if(null == head){
            return null;
        }

        while (head.next!=null){
            next = head.next;
            head.next = pre;

            pre = head;
            head = next;
        }
        head.next = pre;
        return head;
    }

    @Test
    public void testNode(){
        addNode(3);
        addNode(2);
        addNode(1);

        ListNode listNode = reverseNode(pre);
        System.out.println(listNode);


    }



}
