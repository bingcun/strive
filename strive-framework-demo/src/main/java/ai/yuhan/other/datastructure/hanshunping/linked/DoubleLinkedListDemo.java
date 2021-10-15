package ai.yuhan.other.datastructure.hanshunping.linked;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/10/11 22:01
 * @Version 1.0
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode01 HeroNode01 = new HeroNode01(1, "宋江", "及时雨");
        HeroNode01 HeroNode02 = new HeroNode01(2, "吴用", "智多星");
        HeroNode01 HeroNode03 = new HeroNode01(3, "卢俊义", "玉麒麟");
        HeroNode01 HeroNode04 = new HeroNode01(4, "林冲", "豹子头");

        DoubleLinkedList DoubleLinkedList = new DoubleLinkedList();
//        DoubleLinkedList.add(HeroNode0101);
//        DoubleLinkedList.add(HeroNode0102);
//        DoubleLinkedList.add(HeroNode0103);
//        DoubleLinkedList.add(HeroNode0104);


        DoubleLinkedList.addByOrderNo(HeroNode01);
        DoubleLinkedList.addByOrderNo(HeroNode04);
        DoubleLinkedList.addByOrderNo(HeroNode03);
        DoubleLinkedList.addByOrderNo(HeroNode02);

        DoubleLinkedList.list();

//        System.out.println("开始更新");
//        HeroNode01 HeroNode01Update = new HeroNode01(4, "小林", "小豹");
//        DoubleLinkedList.update(HeroNode01Update);
//
//
//        DoubleLinkedList.list();
//
//        System.out.println("开始删除元素");
//        DoubleLinkedList.delete(4);
//
//        DoubleLinkedList.list();


    }

    static class DoubleLinkedList {
        HeroNode01 head = new HeroNode01(0, null, null);

        /**
         * 尾插法
         *
         * @param heroList
         */
        public void add(HeroNode01 heroList) {
            HeroNode01 temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }

            temp.next = heroList;
            heroList.pre = temp;
        }

        /**
         * 在指定位置增加元素,如果元素存在就返回无法插入
         */
        public void addByOrderNo(HeroNode01 heroNode01) {
            HeroNode01 temp = head;
            boolean flag = false;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                if (temp.next.orderNo > heroNode01.orderNo) {
                    break;
                } else if (temp.next.orderNo == heroNode01.orderNo) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                System.out.printf("当前元素编号%d ，已存在\n", temp.orderNo);
            } else {
//                heroNode01.pre = temp;
//                heroNode01 = temp.next;
//                if (temp.next != null) {
//                    temp.next.pre = heroNode01;
//                    temp.pre.next = heroNode01;
//                }
                if(temp.next != null){
                    heroNode01.next = temp.next;
                    temp.next.pre = heroNode01;
                }

                temp.next = heroNode01;
                heroNode01.pre = temp;


            }
        }

        /**
         * 显示所有数据与单链表的遍历操作一样
         */
        public void list() {
            HeroNode01 temp = head.next;
            while (true) {
                if (temp == null) {
                    break;
                }
                System.out.println(temp.toString());
                temp = temp.next;
            }
        }

        /**
         * 更新节点与单链表的遍历方式一样
         *
         * @param HeroNode01
         */
        public void update(HeroNode01 HeroNode01) {
            HeroNode01 temp = head;
            while (true) {
                if (temp == null) {
                    break;
                }
                if (HeroNode01.orderNo == temp.orderNo) {
                    temp.name = HeroNode01.name;
                    temp.nickName = HeroNode01.nickName;
                }
                temp = temp.next;
            }
        }

        /**
         * 删除数据(双向链表的自删除)
         *
         * @param orderNo
         */
        public void delete(int orderNo) {
            HeroNode01 temp = head.next;
            boolean flag = false;
            while (true) {
                if (temp == null) {
                    System.out.println("空节点无法删除");
                    break;
                }
                if (temp.orderNo == orderNo) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.pre.next = temp.next;
                if (temp.next != null) {
                    temp.next.pre = temp.pre;
                }
            } else {
                System.out.println("没有节点可以删除");
            }

        }
    }
}

class HeroNode01 {
    public int orderNo;
    public String name;
    public String nickName;
    public HeroNode01 next;
    public HeroNode01 pre;

    public HeroNode01(int orderNo, String name, String nickName) {
        this.orderNo = orderNo;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode01{" +
                "orderNo=" + orderNo +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}