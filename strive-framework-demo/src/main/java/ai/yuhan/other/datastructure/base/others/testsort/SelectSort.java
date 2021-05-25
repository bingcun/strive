package ai.yuhan.other.datastructure.base.others.testsort;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/14 20:48
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class SelectSort {
    public static void main(String[] args) {
        int array[] = new int[]{2,1,3,4,3,4,5,9};
        SelectSort(array);
    }

    public static int[] SelectSort(int[] array){
        for(int i=0;i<array.length;i++){
            int min = i;
            for(int j=min;j<array.length;j++){
                if(array[j]<array[min]){
                    min = j;
                }
            }

            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
        return array;
    }




}
