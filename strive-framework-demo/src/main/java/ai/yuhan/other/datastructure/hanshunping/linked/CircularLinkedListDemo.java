package ai.yuhan.other.datastructure.hanshunping.linked;

import org.junit.Test;

import javax.swing.plaf.metal.MetalIconFactory;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/10/14 9:47
 * @Version 1.0
 */
public class CircularLinkedListDemo {
    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.addBoy(10);
        circularLinkedList.showBoy();

        circularLinkedList.countBoy(1,2,1);


    }

}
class CircularLinkedList{
    private Boy first = null;
    public void addBoy(int nums){
        if(nums < 1){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针帮助构建环形链表
        //使用for来创建我们的环形链表
        for (int i = 1;i <= nums;i++){
            Boy boy = new Boy(i);
            //如果事第一个小孩
            if(i == 1){
                first = boy;
                first.next = first;
                curBoy = first;//让curBoy指向第一个小孩
            }else {
                curBoy.next = boy;
                boy.next = first;
                curBoy = boy;//让curBoy指向第一个小孩
            }
        }
    }

    /**
     * 遍历小孩的数目
     */
    public void showBoy(){
        if(first == null){
            System.out.println("没有任何小孩~~");
            return;
        }

        Boy curBoy = first;
        while (true){
            System.out.printf("当前小孩的编号%d\n",curBoy.data);
            if(curBoy.next == first){
                break;
            }
            curBoy = curBoy.next;
        }
    }

    /**
     *
     * @param startNo 表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums 表示最初有多少个小孩在圈中
     */
    public void countBoy(int startNo,int countNum,int nums){
        if(first == null || startNo < 1 || startNo > nums){
            System.out.println("输入参数有误,请重新输入");
            return;
        }
        Boy helper = first;
        //需求创建一个辅助指针(变量)helper,事先应该指向环形链表的最后这个节点
        while (true){
            if(helper.next == first){
                break;
            }
            helper = helper.next;
        }

        for(int j=0;j < startNo - 1;j++){
            first = first.next;
            helper = helper.next;
        }

        while (true){
            if(helper == first){
                break;
            }
            //让first和helper指针同时的移动countNum-1
            for (int j=0;j<countNum -1;j++){
                first = first.next;
                helper = helper.next;
            }

            //这时的first指向的节点，就是要出圈的节点
            System.out.printf("小孩%d出圈\n",first.data);
            first = first.next;
            helper.next = first;
        }
        System.out.printf("最后留在圈中的小孩编号%d\n",first.data);
    }

}

class Boy{
    public int data;
    public Boy next;
    public Boy(int data){
        this.data = data;
    }
}