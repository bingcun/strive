package ai.yuhan.other.datastructure;

import java.util.Random;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/14 19:46
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class SkipList {
    private static final int MAX_LEVEL = 16;
    private int levelCount = 1;
    private Node head = new Node();
    private Random random = new Random();

    public Node find(int value){
        Node p = head;
        for(int i = levelCount - 1; i >= 0; i--){
            while(p.forwards[i] != null && p.forwards[i].data < value){
                p = p.forwards[i];
            }
        }
        if(p.forwards[0] != null && p.forwards[0].data == value) return p.forwards[0];
        return null;
    }

    public void insert(int value){
        Node p = head;
        int level = randomLevel();
        Node node = new Node();
        node.data = value;
        node.maxLevel = level;
        Node update[] = new Node[level];
        for(int i = level; i >= 0; i--){
            while(p.forwards[i] != null && p.forwards[i].data < value){
                p = p.forwards[i];
            }
            update[i] = p;
        }
        for(int i = 0; i < level; i++){
            node.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = node;
        }
        if(levelCount < level) levelCount = level;
    }

    public void delete(int value){
        Node[] deleteNode = new Node[MAX_LEVEL];
        Node p = head;
        for(int i = levelCount - 1; i >=0; i--){
            while(p.forwards[i] != null && p.forwards[i].data < value){
                p = p.forwards[i];
            }
            deleteNode[i] = p;
        }
        if(p.forwards[0] != null && p.forwards[0].data == value){
            for(int i = levelCount - 1; i >= 0; i--){
                if(deleteNode[i] != null && deleteNode[i].forwards[i].data == value){
                    deleteNode[i].forwards[i] = deleteNode[i].forwards[i].forwards[i];
                }
            }
        }
    }

    public void printAll(){
        Node p = head;
        while(p.forwards[0] != null){
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }
    private int randomLevel() {
        int level = 0;
        for(int i = 0; i < MAX_LEVEL; i++){
            if(random.nextInt()%2 == 1){
                level++;
            }
        }
        return level;
    }

    class Node{
        private int data;
        private Node[] forwards = new Node[MAX_LEVEL];
        private int maxLevel;

        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("{data: ");
            sb.append(data);
            sb.append("; level: ");
            sb.append(maxLevel);
            sb.append(" }");
            return sb.toString();
        }
    }


}
