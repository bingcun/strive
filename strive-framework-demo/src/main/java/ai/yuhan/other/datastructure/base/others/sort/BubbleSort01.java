package ai.yuhan.other.datastructure.base.others.sort;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/13 17:27
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class BubbleSort01 {

    public static void main(String[] args) {
        int arr[] = new int[]{4,5,6,1,2,7,5,6};
        bubbleSort(arr);
    }

    /**
     * 冒泡排序
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array){
        if(array.length==1){
            return array;
        }

        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j+1]<array[j]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }
}
