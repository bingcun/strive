package ai.yuhan.demo.datastructure.careers.sort;

import java.util.Arrays;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/13 22:39
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class QuickSort02 {

    public static void main(String[] args) {
        int array[] = new int[]{1,9,5,4,2,4,6,8,9,15};
        QuickSort(array);
        System.out.println(Arrays.toString(array));

    }


    public static void QuickSort(int[] array){
        int low = 0;
        int high = array.length-1;
        QuickSort(array,low,high);

    }

    private static void QuickSort(int[] array, int low, int high) {
        if(low < high){
            int index = partion(array,low,high);

            QuickSort(array,low,index-1);

            QuickSort(array,index+1,high);

        }


    }

    private static int partion(int[] array, int low, int high) {
        int i = low;
        int j = high;

        while(i<j){
            while (array[j]>=array[low] && i<j){
                j--;
            }

            if(i<j){
                array[i] = array[j];
                i++;
            }

            while (array[i]<array[low] && i<j){
                i++;
            }

            if(i<j){
                array[j] = array[i];
                j--;
            }
        }
        array[i] = array[low];
        return i;
    }


}
