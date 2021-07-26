package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

import java.util.List;

/**
 * @description: 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * @author: bingcun.chen
 * @Date: 2021/7/17 12:20
 * @Version 1.0
 */
public class offer876 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode middleNode(ListNode head) {
         int right = 1,left = 1;
         ListNode listNode = head;
         while (listNode != null){
             right++;
             listNode = listNode.next;
         }

         int mid = (right + left)/2;
         for(int i =1;i<mid;i++){
             head = head.next;
         }
        return head;
    }

    @Test
    public void test(){
//        ListNode listNode01 = new ListNode(1);
//        ListNode listNode02 = new ListNode(2);
//        ListNode listNode03 = new ListNode(3);
//        ListNode listNode04 = new ListNode(4);
//        ListNode listNode05 = new ListNode(5);
//
//        listNode01.next = listNode02;
//        listNode02.next = listNode03;
//        listNode03.next = listNode04;
//        listNode04.next = listNode05;
//
//        middleNode(listNode01);
//        System.out.println("ssss");

        System.out.println(5%4);
    }

}
