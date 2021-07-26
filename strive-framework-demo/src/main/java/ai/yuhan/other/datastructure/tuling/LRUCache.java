package ai.yuhan.other.datastructure.tuling;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/7/4 12:21
 * @Version 1.0
 */
@Data
class Node{
    public String key;
    public String value;
    public Node pre;
    public Node next;

    Node(String key,String value){
        this.key = key;
        this.value = value;
    }
}
public class LRUCache {
     Node head;
     Node end;

     int limit;

     Map<String,Node> hashMap;

    public LRUCache(int limit){
        this.limit = limit;
        hashMap = new HashMap<>();
    }


    /**
     * 添加元素
     * @param key
     * @param value
     */
    public void put(String key,String value){
        Node node = hashMap.get(key);

        //如果当前Map中没有表示新加入的元素
        if(Objects.isNull(node)){

            //如果当前要加入的元素大于阈值 表示要移除元素 保持LRU
            if(hashMap.size() >= limit){

                //移除掉元素
                String keys = removeNode(head);
                hashMap.remove(key);
            }else {

                //添加元素
                Node node01 = new Node(key,value);
                addNode(node01);
                hashMap.put(key,node01);
            }
        }else {
            node.value = value;
            refreshNode(node);
        }
    }

    /**
     * 刷新Node节点
     * @param node
     */
    private void refreshNode(Node node) {
        if(node == end){
            return;
        }

        removeNode(node);

        addNode(node);
    }

    /**
     * 添加节点
     * @param node
     */
    private void addNode(Node node) {
        if(end != null){
            //双向链表
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
        if(head == null){
            head = node;
        }
    }

    /**
     * 移除节点
     * @param node
     * @return
     */
    private String removeNode(Node node) {
            //移除头节点
        if(node == head){
            head = head.next;
            //移除尾节点
        }else if(node == end) {
            end = end.pre;
        }else {
            //移除中间节点
            //1.前驱的下一个节点赋值给前驱节点
            //2.后继的前一个节点赋值给后继节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }


    public String get(String key){
        Node node=hashMap.get(key);
        if(node==null){
            return null;
        }
        refreshNode(node);
        return node.value;
    }
}

class LRUCacheMAin{
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put("张三","001");
    }


}
