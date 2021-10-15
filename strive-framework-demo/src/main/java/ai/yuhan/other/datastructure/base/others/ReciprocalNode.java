package ai.yuhan.other.datastructure.base.others;

import ai.yuhan.other.datastructure.hanshunping.blockingqueue.ToastQueue;
import org.apache.tools.ant.taskdefs.PathConvert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * 获取链表倒数第K个节点:
 * 1.倒数的节点个数小于等于链表的总长度
 * 2.倒数的节点个数大于链表的总长度
 * @author: bingcun.chen
 * @Date: 2021/10/11 16:38
 * @Version 1.0
 */
public class ReciprocalNode {
    static class ListNode {
        private Integer data;
        private ListNode next;
        public ListNode(Integer data) {
            this.data = data;
            next = null;
        }
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

        ListNode listNode = getKthFromEnd(listNode01, 2);
        System.out.println("11111");

    }


    public ListNode getKthFromEnd(ListNode listNode,int k){
        //0->1->2->3->4
        //倒数第10个节点为0

        //1.倒数第K个节点存在两种情况：
        //1)数据可能大于节点长度
        //2)数据可能小于等于节点长度
        int total = 1;
        ListNode head = listNode;
        while (head != null){
            head = head.next;
            ++total;
        }

        int size = 0;
        if(k > total){
            size = total - (k % total);
        }else {
            size = k;
        }

        ListNode dump = new ListNode(-1);
        dump.next = listNode;
        if(total == size){
            dump = dump.next;
            return dump;
        }
        for (int i=0;i < total - size;i++){
            dump = dump.next;
        }
        return dump;
    }
}
