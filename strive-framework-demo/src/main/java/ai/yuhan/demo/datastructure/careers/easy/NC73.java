package ai.yuhan.demo.datastructure.careers.easy;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @description: 数组中出现次数超过一半的数字
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。1<=数组长度<=50000
 *
 * 输入:
 * [1,2,3,2,2,2,5,4,2]
 *
 * 返回值:
 * 2
 * @author: bingcun.chen
 * @Date: 2021/5/11 21:37
 * @Version 1.0
 */
public class NC73 {

    /**
     * 利用HashMap的特性进行解决
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        int size = array.length;
        if(size==0) return -1;
        if(size==1) return array[0];

        Map<Integer,Integer> maps = new HashMap<>();
        for(int xx:array){
            if(!maps.containsKey(xx)){
                maps.put(xx,1);
            }else{
                int count = maps.get(xx);
                maps.put(xx,++count);
            }
        }

        Iterator iter = maps.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            Integer key =(Integer)entry.getKey();
            Integer val = (Integer)entry.getValue();
            if(val>array.length/2){
                return key;
            }
        }

        return 0;
    }


    public int MoreThanHalfNum_Solution2(int [] array) {
        Arrays.sort(array);
        int i=array[array.length/2];
        return IntStream.of(array).filter(k->k==i).count()>array.length/2?i:0;
    }

    @Test
    public void test01(){
        int[] array = new int[]{3,3,3,3,2,2,2};
        System.out.println(MoreThanHalfNum_Solution(array));


    }


}
