package ai.yuhan.other.datastructure.hanshunping.queue;

import javax.print.attribute.standard.Sides;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description: 环形数组解决循环使用队列的问题
 * @author: bingcun.chen
 * @Date: 2021/10/10 22:22
 * @Version 1.0
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);


        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(3);
        blockingQueue.add(1);
        blockingQueue.add(2);
        blockingQueue.add(3);
        blockingQueue.add(4);
    }


    static class ArrayQueue{
        //队列的最大长度
        private int maxSize;
        //head 变量的含义做一个调整： head 就指向队列的第一个元素, 也就是说 arr[head] 就是队列的第一个元素
        //head 的初始值 = 0
        private int head;
        //tail 变量的含义做一个调整：tail 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
        //tail的初始值为 = 0
        private int tail;
        //队列的长度
        private int[] queue;

        public ArrayQueue(int size){
            maxSize = size;
            queue = new int[size];
        }

        /**
         * 判断队列是否满
         * @return
         */
        public boolean isFull(){
            return (tail + 1) % maxSize == head;
        }

        /**
         * 判断队列是否为空
         * @return
         */
        public boolean isEmpty(){
            return head == tail;
        }

        /**
         * 添加队列在尾部
         * @param data
         */
        public void add(int data){
            if(isFull()){
                System.out.println("队列已满,不能添加!");
                return;
            }
            queue[tail] = data;
            //将尾部的指针后移然后取模
            tail = (tail + 1) % maxSize;
        }

        /**
         * 取数据
         * @return
         */
        public int getQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列为空不能取数据");
            }
            head = (head + 1) % maxSize;
            return queue[head];
        }

        /**
         * 显示数据
         */
        public void show(){
         for (int i = 0;i<head + size();i++){
             System.out.printf("arr[%d]=d%\n",i % maxSize,queue[i % maxSize]);
         }
        }

        /**
         * 求出当前队列有效数据的个数
         * @return
         */
        private int size() {
            return (tail + maxSize - head) % maxSize;
        }

        /**
         * 显示队列的头数据，注意不是取出数据
         * @return
         */
        public int headQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列为空的，没有数据~");
            }
            return queue[head];
        }


    }



}
