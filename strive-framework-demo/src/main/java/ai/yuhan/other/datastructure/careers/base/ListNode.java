package ai.yuhan.other.datastructure.careers.base;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/5/17 12:13
 * @Version 1.0
 */
public class ListNode<E> {
    private E e;   //数据data
    private ListNode<E> next; //指向下一个节点

    public ListNode() {

    }

    public ListNode(E e) {
        this.e = e;
    }

    public ListNode<E> getNext() {
        return next;
    }

    public void setNext(ListNode<E> next) {
        this.next = next;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }


}
