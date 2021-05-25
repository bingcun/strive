package ai.yuhan.other.datastructure.tuling;

import org.junit.Test;

/**
 * @description:
 * 返回阶梯行的总行数
 * 第一行  *
 * 第二行  * *
 * 第三行  * * *
 * 第四行  * * * *
 * 第五行  * * * * *
 * @author: bingcun.chen
 * @Date: 2021/5/21 21:20
 * @Version 1.0
 */
public class NC012 {

    /**
     * 穷举的方式暴力破解法
     * @param n
     * @return
     */
    public int arrangeCoins(int n){
        for(int i=1;i<=n;i++){
            n = n-i;
            if(n<i)return i;
        }
        return 0;
    }

    @Test
    public void test01(){
        System.out.println(arrangeCoins(10));
    }

    /**
     * 二分查找法解决问题
     *
     * 以16为例:
     * 第一轮:low=0,high=16,mid=8,coins=36,n=16
     * 第二轮:low=0,high=7 ,mid=3,coins=6,n=16
     * 第三轮:low=4,high=7 ,mid=5,coins=15,n=16
     * 第四轮:low=6,high=7 ,mid=6,coins=21,n=16
     * 第五轮:low=6,high=5, low>high 返回最后一个high的值
     * @param n
     * @return
     */
    public int arrangeConins2(int n){
        int low = 0,high = n;
        while(low<=high){
            int mid = (high - low)/2 + low;
            int cost = ((mid + 1) * mid) / 2;
            if(cost == n){
                return mid;
            }else if(cost > n){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }

//    /**
//     * 二分查找的方式找硬币
//     * @param n
//     * @return
//     */
//    public int arrangtCoins3(int n){
//        int low = 0,high = n;
//        while (low <= high){
//            int mid = (high - low)/2 + low;
//            int cost = ((mid + 1) * mid) / 2;
//            if(n == cost){
//                return mid;
//            }else if(n > cost){
//                low = mid + 1;
//            }else{
//                high = mid - 1;
//            }
//        }
//
//        return high;
//    }



    @Test
    public void test02(){
        System.out.println(arrangeConins2(16));
    }
}
