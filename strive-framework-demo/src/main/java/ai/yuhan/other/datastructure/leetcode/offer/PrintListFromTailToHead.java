package ai.yuhan.other.datastructure.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/20 16:46
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class PrintListFromTailToHead {

    public static void main(String[] args) {
        ListNode listNode0 = new ListNode();
        listNode0.val = 19;
        ListNode listNode1 = new ListNode();
        listNode1.val = 67;
        ListNode listNode2 = new ListNode();
        listNode2.val = 0;
        ListNode listNode3 = new ListNode();
        listNode3.val = 16;
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        printListFromTailToHead(listNode0);


    }

//    /**
//     * 第一种通过压栈的方式
//     * @param listNode
//     * @return
//     */
//    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        //压栈 利用栈的特性来做
//        Stack<ListNode> listNodeStack = new Stack<>();
//        ListNode temp = listNode;
//        //判断是不是最后一个
//        while (temp!=null){
//            listNodeStack.add(temp);
//            temp = temp.next;
//        }
//
//        int size = listNodeStack.size();
//        for(int i=0;i<size;i++){
//            arrayList.add(listNodeStack.pop().val);
//        }
//        return arrayList;
//    }


    /**
     * 第二种倒排数组
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //记录链表的大小
        int size = 0;
        ListNode temp = listNode;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        //重置链表
        temp = listNode;
        Integer[] array = new Integer[size];
        for(int i=size-1;i>=0;i--){
            array[i] = temp.val;
            temp = temp.next;
        }
        return new ArrayList<Integer>(Arrays.asList(array));
    }

    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(){}
        ListNode(int val) {
            this.val = val;
        }
    }
}
