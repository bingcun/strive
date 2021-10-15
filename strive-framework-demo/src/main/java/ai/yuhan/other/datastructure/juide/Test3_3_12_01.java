package ai.yuhan.other.datastructure.juide;

import org.junit.Test;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/8/22 17:28
 * @Version 1.0
 */
public class Test3_3_12_01 {

    /**
     * 二维数组的查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int xLength = matrix.length - 1;
        int yLength = 0;

        while (xLength >= 0 && yLength < matrix[0].length){
            if(matrix[xLength][yLength] == target){
                return true;
            }else if(matrix[xLength][yLength]<target){
                yLength++;
            }else {
                xLength--;
            }
        }
        return false;
    }

    @Test
    public void test(){
        int[][] arr = new int[5][5];
        int[] arr01 = new int[]{1,   4,  7, 11, 15};
        int[] arr02 = new int[]{2,   5,  8, 12, 19};
        int[] arr03 = new int[]{3,   6,  9, 16, 22};
        int[] arr04 = new int[]{10, 13, 14, 17, 24};
        int[] arr05 = new int[]{18, 21, 23, 26, 30};
        arr[0]= arr01;
        arr[1]= arr02;
        arr[2]= arr03;
        arr[3]= arr04;
        arr[4]= arr05;


        System.out.println(findNumberIn2DArray(arr, 1));

    }

}
