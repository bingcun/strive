package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 * @author: bingcun.chen
 * @Date: 2021/6/22 20:26
 * @Version 1.0
 */
public class offer11 {

    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }

    /**
     * 二分查找
     * @return
     */
    public int binarySearch(int[] numbers){
        int low = 0,high = numbers.length - 1;

        while (low < high){

            int mid = low + (low + high) / 2;

            if(numbers[mid] < numbers[high] ){
                high = mid;
            }else if(numbers[mid]>numbers[high]){
                low = mid + 1;
            }else {
                high -= 1;
            }
        }

        return numbers[low];
    }

    @Test
    public void test(){
        int[] numbers = new int[]{3,4,5,1,2};
        System.out.println(minArray(numbers));
        System.out.println(binarySearch(numbers));
    }
}
