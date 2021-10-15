package ai.yuhan.other.datastructure.hanshunping.recursion;

import org.apache.poi.hssf.record.TableRecord;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/10/15 9:51
 * @Version 1.0
 */
public class MiGong {
    public static void main(String[] args) {
        int[][] arr = new int[8][7];
        //初始化四周类型为挡板
        for (int i = 0;i<arr.length;i++) {
            arr[i][0] = 1;
            arr[i][6] = 1;
        }

        for (int i = 0;i<arr.length;i++) {
            for(int j = 0;j<arr[i].length;j++){
                arr[0][j] = 1;
                arr[7][j] = 1;
            }
        }

        arr[3][1] = 1;
        arr[3][2] = 1;

        setWays(arr,1,1);

        for (int[] ints:arr){
            for (int data:ints){
                System.out.printf("%d ",data);
            }
            System.out.println();
        }




    }


    public static boolean setWays(int[][] arr,int i,int j){
        //表示通路已经OK
        if(arr[6][5] == 2){
            return true;
        }else{
            if(arr[i][j] == 0){
                //从哪开始走的路径肯定是入口,所以初始化入口
                arr[i][j] = 2;
                //设置策略 下->右->上->左
                if(setWays(arr,i + 1,j)){
                    return true;
                }else if(setWays(arr,i,j+1)){
                    return true;
                }else if(setWays(arr,i-1,j)){
                    return true;
                }else if(setWays(arr,i,j - 1)){
                    return true;
                }else {
                    arr[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }

}
