package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/6/5 19:41
 * @Version 1.0
 */
public class offer22 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 通过反向循环找到正序的位置获取节点的下一个位置
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        int size = 0;
        ListNode curr = head;
        while (curr != null){
            ++size;
            curr = curr.next;
        }

        if(size <= k){
            return head;
        }

        int count = size -k;
        ListNode newCurr = head;
        ListNode finalNode = null;
        for(int i=0;i<count;i++){
            if(i == count - 1){
               finalNode = newCurr.next;
               break;
            }
            newCurr = newCurr.next;
        }
        return finalNode;
    }

    /**
     * 快慢指针，先让快指针走k步，然后两个指针同步走，
     * 当快指针走到头时，慢指针就是链表倒数第k个节点。
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd01(ListNode head, int k) {
        ListNode fastNode = head,slowNode = head;

        //1.快指针走K步
        while (fastNode != null && k > 0){
            fastNode = fastNode.next;
            k--;
        }

        //2.慢指针走总数-K步 返回慢指针即为结果
        while (fastNode != null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
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

        ListNode kthFromEnd = getKthFromEnd01(listNode01, 2);

        System.out.println("ssss");
    }


}
