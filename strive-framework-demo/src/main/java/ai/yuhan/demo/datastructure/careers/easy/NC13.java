package ai.yuhan.demo.datastructure.careers.easy;

/**
 * @description: 二叉树的最大深度
 * 求给定二叉树的最大深度，
 * 最大深度是指树的根结点到最远叶子结点的最长路径上结点的数量。
 *
 * 输入:{1,2}
 * 返回:2
 *
 * @author: bingcun.chen
 * @Date: 2021/5/17 18:40
 * @Version 1.0
 */
public class NC13 {
    public static class ListNode{
        private int val;
        private ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }


    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
            if(p1 != p2){
                if(p1 == null)p1 = pHead2;
                if(p2 == null)p2 = pHead1;
            }
        }
        return p1;
    }


}
