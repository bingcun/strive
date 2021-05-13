package ai.yuhan.demo.datastructure.base.others;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/15 18:22
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class ChildrenArray {

    public static void main(String[] args) {
        int array[] = new int[]{1,5,-4,-2,7,-6,2,-3};
        System.out.println(maxsumofSubarray(array));


    }

    /**
     * max sum of the subarray
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public static int maxsumofSubarray (int[] arr) {
        int n = arr.length;
        if(n==1){
            return arr[0];
        }
        int max = 0;
        // write code here
        for(int i=1;i<arr.length;i++){
            arr[i] = Math.max(arr[i],arr[i-1]+arr[i]);
            max = Math.max(max,arr[i]);
        }
        return max;
    }




}
