package ai.yuhan.other.datastructure.careers.middle;

import org.junit.Test;

/**
 * @description: 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 * 输入:[1,3,5,2,2],5,3
 * 返回值:2
 * @author: bingcun.chen
 * @Date: 2021/5/10 22:01
 * @Version 1.0
 */
public class NC88 {

    public int[]arr = new int[]{87,23,65,82,92};

    @Test
    public void test01(){
        System.out.println(findKth(arr, arr.length, 3));
    }

    /**
     * 快排解决思路解决第K小的数
     * @param a
     * @param n
     * @param K
     * @return
     */
    public int findKth(int[] a, int n, int K) {
        // write code here
        return findK(a, 0, n - 1, K);
    }

    /**
     * 快排方法:
     * 第一轮:
     * @param arr
     * @param left
     * @param right
     * @param k
     * @return
     */
    public static int findK(int[] arr, int left, int right, int k) {
        if (left <= right) {
            int pivot = partition(arr, left, right);

            if (pivot == k - 1) {
                return arr[pivot];
            } else if (pivot < k - 1) {
                return findK(arr, pivot + 1, right, k);
            } else {
                return findK(arr, left, pivot - 1, k);
            }
        }
        return -1;
    }

    //正常数据:[87,23,65,82,92]
    //1轮:[92, 23, 65, 82, 23]
    //2轮:[92,87,65,82,23]
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] <= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] >= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }



}
