package ai.yuhan.other.datastructure.hanshunping.linked;

import lombok.Data;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/10/11 22:01
 * @Version 1.0
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode01 = new HeroNode(1,"宋江","及时雨");
        HeroNode heroNode02 = new HeroNode(2,"吴用","智多星");
        HeroNode heroNode03 = new HeroNode(3,"卢俊义","玉麒麟");
        HeroNode heroNode04 = new HeroNode(4,"林冲","豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(heroNode01);
//        singleLinkedList.add(heroNode02);
//        singleLinkedList.add(heroNode03);
//        singleLinkedList.add(heroNode04);


        singleLinkedList.addByOrderNo(heroNode01);
        singleLinkedList.addByOrderNo(heroNode04);
        singleLinkedList.addByOrderNo(heroNode02);
        singleLinkedList.addByOrderNo(heroNode03);

        singleLinkedList.list();

        System.out.println("开始更新");
        HeroNode heroNodeUpdate = new HeroNode(4,"小林","小豹");
        singleLinkedList.update(heroNodeUpdate);


        singleLinkedList.list();

        System.out.println("开始删除元素");
        singleLinkedList.delete(heroNodeUpdate);

        singleLinkedList.list();


    }

    static class SingleLinkedList{
        HeroNode head = new HeroNode(0,null,null);
        /**
         * 尾插法
         * @param heroList
         */
        public void add(HeroNode heroList){
            HeroNode temp = head;
            while (true){
                if(temp.next == null){
                    break;
                }
                temp = temp.next;
            }
            temp.next = heroList;
        }

        /**
         * 在指定位置增加元素,如果元素存在就返回无法插入
         */
        public void addByOrderNo(HeroNode heroNode){
            HeroNode temp = head;
            boolean flag = false;
            while (true){
                if(temp.next == null){
                    break;
                }
                if(temp.next.orderNo > heroNode.orderNo){
                    break;
                }else if(temp.next.orderNo == heroNode.orderNo){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if(flag){
                System.out.printf("当前元素编号%d ，已存在\n",temp.orderNo);
            }else {
                heroNode.next = temp.next;
                temp.next = heroNode;
            }
        }

        /**
         * 显示所有数据
         */
        public void list(){
            HeroNode temp = head.next;
            while (true){
                if(temp == null){
                    break;
                }
                System.out.println(temp.toString());
                temp = temp.next;
            }
        }

        /**
         * 更新节点
         * @param heroNode
         */
        public void update(HeroNode heroNode){
            HeroNode temp = head;
            while (true){
                if(temp == null){
                    break;
                }
                if(heroNode.orderNo == temp.orderNo){
                    temp.name = heroNode.name;
                    temp.nickName = heroNode.nickName;
                }
                temp = temp.next;
            }
        }

        /**
         * 删除数据
         * @param heroNode
         */
        public void delete(HeroNode heroNode){
            HeroNode temp = head;
            while (true){
                if(temp == null){
                    break;
                }
                if(temp.next.orderNo == heroNode.orderNo){
                    temp.next = temp.next.next;
                    System.out.println("删除成功");
                    break;
                }
                temp = temp.next;
            }
        }
    }
}

class HeroNode{
    public int orderNo;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int orderNo,String name,String nickName){
        this.orderNo = orderNo;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "orderNo=" + orderNo +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}