package ai.yuhan.other.datastructure.base.others;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/16 11:28
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class NodeRound {
    public boolean isRound(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast==slow)return true;
        }

        return false;
    }
}
class ListNode{
     int val;
     ListNode next;
}