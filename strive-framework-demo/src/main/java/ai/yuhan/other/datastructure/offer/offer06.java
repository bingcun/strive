package ai.yuhan.other.datastructure.offer;

import javafx.beans.WeakInvalidationListener;
import org.junit.Test;
import sun.util.resources.cldr.ur.CurrencyNames_ur;

import java.net.CacheRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/6/5 20:35
 * @Version 1.0
 */
public class offer06 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 递归到最后从后往前转换数据
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode Node = reversePrint(head,list);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    private ListNode reversePrint(ListNode head, List<Integer> list) {
        if(head == null) return head;
        ListNode node =reversePrint(head.next,list);
        list.add(head.val);
        return node;
    }

    /**
     * 借助栈实现
     * @param head
     * @return
     */
    public int[] reversePrint01(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode curr = head;
        int size = 0;
        while (curr != null){
            stack.push(curr.val);
            ++size;
            curr = curr.next;
        }

        int[] result = new int[size];

        for(int i=0;i<size;i++){
            result[i] = stack.pop();
        }
        return result;
    }

    /**
     * 不用递归和栈实现倒着打印链表
     * @param head
     */
    public int[] reversePrint02(ListNode head){
        int size = 0;
        ListNode curr = head;
        //1.拿到链表的长度
        while (curr != null){
            ++size;
            curr = curr.next;
        }

        curr = head;
        //2.初始化数组
        int[] result = new int[size];
        for(int i = size-1;i>=0;i--){
            result[i] = curr.val;
            curr = curr.next;
        }

        return result;
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

        int[] ints = reversePrint02(listNode01);
        System.out.println(Arrays.toString(ints));
    }
    
}
