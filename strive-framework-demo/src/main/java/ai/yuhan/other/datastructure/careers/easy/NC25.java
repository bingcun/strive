package ai.yuhan.other.datastructure.careers.easy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 删除有序链表中重复的元素
 * 删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
 * 例如：
 * 给出的链表为1->1->2,返回1→2.
 * 给出的链表为1->1->2->3,返回1->2→3.
 * @author: bingcun.chen
 * @Date: 2021/5/17 9:46
 * @Version 1.0
 */
public class NC25 {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListNode{
        private int data;
        private ListNode next;
    }

    //todo 需要重构部分逻辑
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode current = head;
        Set<Integer> sets = new HashSet<>();
        while (current != null){
          sets.add(current.data);
          current = current.next;
        }

        //重建ListNode
        ListNode listNode = new ListNode();
        //todo 通过set去重了数据,但是重组链表中的数据,这块比较麻烦先暂时保留
        return null;
    }

    public ListNode deleteDuplicates01 (ListNode head) {
        if(head == null) return head;

        ListNode temp = head;
        while (temp.next != null){
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return head;
    }


    @Test
    public void test01(){
        ListNode data04 = new ListNode(3,null);
        ListNode data03 = new ListNode(2,data04);
        ListNode data02 = new ListNode(1,data03);
        ListNode data01 = new ListNode(1,data02);

        ListNode listNode = deleteDuplicates01(data01);
        System.out.println(listNode);

    }


}
