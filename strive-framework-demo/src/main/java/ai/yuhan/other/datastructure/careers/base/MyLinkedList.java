package ai.yuhan.other.datastructure.careers.base;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/5/17 12:17
 * @Version 1.0
 */
public class MyLinkedList<E> {
    //声明头节点尾节点
    private ListNode<E> head;
    private ListNode<E> last;
    //链表的大小
    private int size;
    private int modcount; //计算被修改的次数

    public MyLinkedList() {
        head = new ListNode<E>();//实例化头结点
        last = head;
    }

    /*
     *返回单链表中存储的元素总数
     */
    public int size() {
        return size;
    }

    /*
     *获取指定索引位置的节点对象
     */
    public ListNode<E> get(int index) {
        if (index < 0 || index > size - 1)
            return null;
        ListNode<E> ListNode = head.getNext();//将头结点的下一个节点赋给ListNode
        for (int i = 0; i < index; i++) {
            ListNode = ListNode.getNext();//获取ListNode的下一个节点
        }
        return ListNode;
    }

    /*
     *获取指定索引位置的数据
     */
    public E getValue(int index) {
        if (index < 0 || index > size - 1)
            return null;
        ListNode<E> ListNode = get(index);
        return ListNode.getE();
    }

    /*
     *增加元素
     */
    public void add(E e) {
        ListNode<E> ListNode = new ListNode<E>(e); //以e实例化一个节点
        last.setNext(ListNode);//往尾节点后追加节点
        last = ListNode;//该节点设为最后一个节点
        size++;
        modcount++;
    }

    /*
     *指定位置插入元素,返回插入的节点数据
     */
    public E add(int index, E e) {
        if (index < 0 || index > size - 1)
            return null;
        ListNode<E> ListNode = new ListNode<E>(e); //实例化一个节点
        //找到插入的原节点
        ListNode<E> oldListNode = get(index);
        if (index == 0) {//当索引为0时
            head.setNext(ListNode);
        } else {
            //找到插入节点的上一个
            ListNode<E> bListNode = get(index - 1);
            bListNode.setNext(ListNode);
        }
        ListNode.setNext(oldListNode);
        size++;
        modcount++;
        return oldListNode.getE();
    }

    /*
     *删除指定的节点e,并返回删除节点的数据
     */
    public E delete(int index) {
        if (index < 0 || index > size - 1)
            return null;
        if (index == 0) {//当索引为1，令头结点的下一个节点为头结点
            ListNode<E> ListNode = head.getNext();
            head.setNext(ListNode.getNext());
        }
        //获取要删除节点的前一个节点
        ListNode<E> bListNode = get(index - 1);
        //获取要删除的节点
        ListNode<E> ListNode = bListNode.getNext();
        //获取要删除节点的下一个节点
        ListNode<E> nListNode = ListNode.getNext();
        //删除该节点
        bListNode.setNext(nListNode);
        //清除ListNode的下一个节点
        ListNode.setNext(null);
        size--;
        modcount++;
        return ListNode.getE();//返回节点中的数据域
    }

    /*
     *修改指定位置的数据域并返回修改后的数据
     */
    public E set(int index, E e) {
        if (index < 0 || index > size - 1)
            return null;
        //获取指定位置的原节点
        ListNode<E> ListNode = get(index);
        ListNode.setE(e);
        modcount++;
        return ListNode.getE();
    }
}
