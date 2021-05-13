package ai.yuhan.demo.datastructure.base.others.sort;

import java.util.Arrays;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/14 16:34
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class SelectSort03 {
    public static void main(String[] args) {
        int array[] = new int[]{1,5,7,4,8,2,6,4};

        System.out.println(Arrays.asList(selectSort(array)).toString());
    }


    /**
     * 选择排序的算法:每次选择数组中最小的元素,然后与当前队列进行交换。
     * @param array
     * @return
     */
    public static int[] selectSort(int[] array){
        if(array.length==0){
            return array;
        }

        for(int i=0;i<array.length;i++){
            int minIndex = i;
            for(int j = i;j<array.length;j++){
                if(array[j]<array[minIndex]){
                    minIndex = j;
                }
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }




}
