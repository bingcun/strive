package ai.yuhan.other.datastructure.juide;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/8/19 13:57
 * @Version 1.0
 */
public class Test3_3_4 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 计算两个数的和
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1,q = l2,curr = dummyHead;

        int carry = 0;
        //从低位往高位进行计算累加 注意进位
        while (p!=null || q!=null){
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            int sum = carry + x + y;
            //进位数
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            //第一个数不为空 往后走一位
            if(p != null)p = p.next;
            //第二个数不为空 往后走一位
            if(q != null)q = q.next;
        }

        //最新进位不为0 表示有新的进位增加一个节点
        if(carry > 0){
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }


}
