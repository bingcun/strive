package ai.yuhan.other.datastructure.hanshunping.Sparsearray;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/10/10 20:39
 * @Version 1.0
 */
public class SparseArray01 {
    public static void main(String[] args) {
        //初始化的数组和稀疏数组 int[11][11]
        // 0 0 0 0 0 0 0 0 0 0 0
        // 0 0 1 0 0 0 0 0 0 0 0
        // 0 0 0 2 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0 0 0
        // 0 0 0 0 0 0 0 0 0 0 0

        //转化成稀疏数组
        // number row col value
        //    0   11  11   2
        //    1   1   2    1
        //    2   2   3    2

        //初始化一个数组
        System.out.println("初始化的矩阵为~~");
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;

        int rowLength = arr.length;
        int colLength = 0;
        for (int i = 0;i<arr.length;i++) {
            for (int j = 0; j<arr[i].length ; j++) {
                System.out.printf("%d\t",arr[i][j]);
                colLength = j;
            }
            System.out.println();
        }

        System.out.println("将矩阵转化为稀疏矩阵~~");

        //查找稀疏矩阵的非零总数
        int count = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if(anInt != 0){
                    count++;
                }
            }
        }
        //初始化稀疏矩阵大小
        int[][] sparseArr = new int[3][++count];
        sparseArr[0][0] = rowLength;
        sparseArr[0][1] = ++colLength;
        sparseArr[0][2] = count;

        int count01 = 0;
        for (int i = 0;i<arr.length;i++) {
            for (int j = 0; j<arr[i].length ; j++) {
                if(arr[i][j]!=0){
                    count01++;
                    sparseArr[count01][0] = i;
                    sparseArr[count01][1] = j;
                    sparseArr[count01][2] = arr[i][j];
                }
            }
        }

        for (int i=0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }

        System.out.println("将稀疏矩阵转化成新矩阵~~");

        int[][] arr01 = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1;i<sparseArr.length;i++) {
            arr01[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        for (int i = 0;i<arr01.length;i++) {
            for (int j = 0; j<arr01[i].length ; j++) {
                System.out.printf("%d\t",arr01[i][j]);
            }
            System.out.println();
        }


    }


}
