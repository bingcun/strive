package ai.yuhan.other.datastructure.hanshunping.queue;


import java.util.Arrays;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/10/10 22:00
 * @Version 1.0
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);

        System.out.println(arrayQueue.getQueue());
        Arrays.stream(arrayQueue.show()).forEach(System.out::println);

    }



  static class ArrayQueue{
      //队列的最大长度
      private int maxSize;
      //队列的头指针
      private int head;
      //队列的尾指针
      private int tail;
      //队列的长度
      private int[] queue;

      public ArrayQueue(int size){
          maxSize = size;
          queue = new int[size];
          //初始化头指针
          head = -1;
          //初始化尾指针
          tail = -1;
      }

      /**
       * 判断队列是否满
       * @return
       */
      public boolean isFull(){
          return maxSize - 1 == tail;
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
          tail++;
          queue[tail] = data;
      }

      /**
       * 取数据
       * @return
       */
      public int getQueue(){
          if(isEmpty()){
              throw new RuntimeException("队列为空不能取数据");
          }
          head++;
          return queue[head];
      }

      /**
       * 显示数据
       */
      public int[] show(){
          return queue;
      }


  }
}
