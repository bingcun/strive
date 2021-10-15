package ai.yuhan.other.multithreading.thread.offer1115.cyclicbarrier;

import org.junit.Test;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/7/31 16:16
 * @Version 1.0
 */
public class TestFooBar {

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(10);
        Runnable printFoo = () -> {
            System.out.printf("%s\n","foo");
        };

        Runnable printBoo = () -> {
            System.out.printf("%s\n","boo");
        };

        Thread fooThread = new Thread(()->{
           fooBar.foo(printFoo);
        });

        Thread booThread = new Thread(() -> {
            fooBar.boo(printBoo);
        });

        fooThread.start();
        booThread.start();

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode temp = node;

        while (l1 != null && l2!=null){
            if(l1.val < l2.val){
                ListNode l3 = l1.next;
                l1.next = null;
                temp.next = l1;
                l1 = l3;
            }else{
                ListNode l4 = l2.next;
                l2.next = null;
                temp.next = l2;
                l2 = l4;
            }
            temp = temp.next;
        }

        if(l1 == null)temp.next = l2;
        if(l2 == null)temp.next = l1;


        return node.next;

    }

    @Test
    public void test(){
        ListNode listNode01 = new ListNode(1);
        ListNode listNode02 = new ListNode(2);
        ListNode listNode03 = new ListNode(4);
        listNode01.next = listNode02;
        listNode02.next = listNode03;


        ListNode listNode04 = new ListNode(1);
        ListNode listNode05 = new ListNode(3);
        ListNode listNode06 = new ListNode(4);
        listNode04.next = listNode05;
        listNode05.next = listNode06;


        ListNode listNode = mergeTwoLists(listNode01, listNode04);
        System.out.println("ssssss");

    }









}
