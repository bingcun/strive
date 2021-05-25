package ai.yuhan.other.datastructure.base.others.sort;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/14 20:58
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class InsertSort {
    public static void main(String[] args) {
        int arr[] = new int[]{1,4,8,2,4,6};
        InsertSort(arr);
    }


    /**
     * 插入排序的逻辑后一个值和前一个值进行对比，如果小于前一个值大于前一个值的前一个值，
     * 通过复制后面的值的方式，插入当前值到前一个值这里
     *
     * @param array
     * @return
     */
    public static int[] InsertSort(int[] array) {
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int pre = i;
            while (pre >= 0 && current < array[pre]) {
                array[pre + 1] = current;
                pre--;
            }
            array[pre + 1] = current;
        }
        return array;
    }


}
