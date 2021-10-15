package ai.yuhan.other.datastructure.hanshunping.linked.ques;
import org.junit.Test;
import java.util.Stack;

/**
 * @description: 求链表中有效节点个数
 * @author: bingcun.chen
 * @Date: 2021/10/13 15:31
 * @Version 1.0
 */
public class Question {

    @Test
    public void question01(){
        ListNode listNode = init();
        int sum = 0;
        while (listNode.next != null){
            listNode= listNode.next;
            sum++;
        }
        System.out.println(sum);
    }

    @Test
    public void question02(){
        ListNode listNode = init();
        ListNode orderKNode = findOrderKNode(listNode.next, 2);

        ListNode orderKNodeDoubleLinkedList = findOrderKNodeDoubleLinkedList(listNode.next, 2);

        System.out.println("sssss");
    }

    @Test
    public void question03(){
        ListNode listNode = init();
        ListNode listNode1 = reverseListNode(listNode);
        System.out.println();
    }

    /**
     * 从尾到头打印单链表(通过栈的方式打印)
     */
    @Test
    public void question04(){
        ListNode listNode = init().next;

        if(listNode == null){
            System.out.println("当前节点为空不能打印");
            return;
        }

        Stack<ListNode> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode);
            listNode = listNode.next;
        }

        while (stack.size() > 0){
            System.out.println(stack.pop().toString());
        }

    }

    @Test
    public void question05(){
        ListNode listNode01 = init().next;
        ListNode listNode02 = init2().next;
        ListNode listNode = mergeTwoListNode(listNode01, listNode02);
        while (listNode != null){
            System.out.println(listNode.toString());
            listNode = listNode.next;
        }

    }

    /**
     * 反转链表
     * @return
     */
    public ListNode reverseListNode(ListNode listNode){
        if(listNode == null || listNode.next == null)return listNode;

        ListNode temp = listNode.next;
        ListNode first = null;
        while (temp != null){
            ListNode temp03 = temp.next;
            temp.next = first;
            first = temp;
            temp = temp03;
        }
        return first;
    }

    /**
     * 查找单链表中倒数第K个节点
     */
    public ListNode findOrderKNode(ListNode listNode,int k){
        int temp = 0;
        ListNode tempNode = listNode;
        while (tempNode.next != null){
            tempNode = tempNode.next;
            temp++;
        }

        ListNode cur = listNode.next;
        for(int i = 0;i < temp - k;i++){
            cur = cur.next;
        }
        return cur;
    }


    /**
     * 查找单链表中倒数第K个节点
     */
    public ListNode findOrderKNodeDoubleLinkedList(ListNode listNode,int k){
        ListNode fastNode = listNode;
        ListNode slowNode = listNode;

        for(int i = 0 ;i < k;i++){
            fastNode = fastNode.next;
        }

        while (fastNode != null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        return slowNode;
    }


    /**
     * 初始化数据
     * @return
     */
    public ListNode init(){
        ListNode listNode = ListNode.getHead();
        ListNode listNode01 = new ListNode(1);
        ListNode listNode02 = new ListNode(2);
        ListNode listNode03 = new ListNode(3);
        ListNode listNode04 = new ListNode(4);
        ListNode listNode05 = new ListNode(5);
        listNode.next = listNode01;
        listNode01.next = listNode02;
        listNode02.next = listNode03;
        listNode03.next = listNode04;
        listNode04.next = listNode05;
        return listNode;
    }

    /**
     * 初始化第二组数据
     * @return
     */
    public ListNode init2(){
        ListNode listNode = ListNode.getHead();
        ListNode listNode01 = new ListNode(3);
        ListNode listNode02 = new ListNode(4);
        ListNode listNode03 = new ListNode(8);
        ListNode listNode04 = new ListNode(9);
        ListNode listNode05 = new ListNode(10);
        listNode.next = listNode01;
        listNode01.next = listNode02;
        listNode02.next = listNode03;
        listNode03.next = listNode04;
        listNode04.next = listNode05;
        return listNode;
    }


    /**
     * 合并两个单链表(有序的),合并之后仍然是有序的
     * @return
     */
    public ListNode mergeTwoListNode(ListNode listNode01,ListNode listNode02){
        ListNode head = new ListNode(0),curr = head;
        while (listNode01 != null && listNode02 != null){
            if(listNode01.data < listNode02.data){
                curr.next = listNode01;
                curr = curr.next;
                listNode01 = listNode01.next;
            }else {
                curr.next = listNode02;
                curr = curr.next;
                listNode02 = listNode02.next;
            }
        }

        curr.next = listNode01 == null ? listNode02 : listNode01;
        return head.next;
    }


}
class ListNode{
    public int data;
    public ListNode next;
    public static ListNode head = new ListNode(0);
    public ListNode(int data){
        this.data = data;
    }
    public static ListNode getHead(){
        return head;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
                '}';
    }
}
