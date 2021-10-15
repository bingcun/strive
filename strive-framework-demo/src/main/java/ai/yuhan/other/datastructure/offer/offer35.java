package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 复杂链表的复制
 *
请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * @author: bingcun.chen
 * @Date: 2021/8/5 10:06
 * @Version 1.0
 */
public class offer35 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. 构建新链表的 next 和 random 指向
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);
    }

    @Test
    public void test(){
        Node node01 = new Node(7);
        Node node02 = new Node(13);
        Node node03 = new Node(11);
        Node node04 = new Node(10);
        Node node05 = new Node(1);

        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;

        node01.random = null;
        node02.random = node01;
        node03.random = node05;
        node04.random = node03;
        node05.random = node01;


        Node node = copyRandomList(node01);
        System.out.println("ssssss");
    }

}
