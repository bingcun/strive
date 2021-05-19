package ai.yuhan.demo.datastructure.tuling;

/**
 * @description:
 * x的平方根在不使用sqrt(x)函数的情况下,得到x的
 * @author: bingcun.chen
 * @Date: 2021/5/18 18:25
 * @Version 1.0
 */
public class NC005 {

    /**
     * x的平方根肯定在0到x之间，使用二分查找定位该数字，该数字的平方一定是最接近x的，m平方值如果
     * 大于x、则往左边找，如果小于等于x则往右边找
     * 找到0和X的最中间的数m，
     * 如果m * m > x，则m取x/2到x的中间数字，直到m * m < x，m则为平方根的整数部分
     * 如果m * m <= x，则取0到x/2的中间值，知道两边的界限重合，找到最大的整数，则为x平方根的整数部分
     * @param x
     * @return
     */
    public static int binarySearch(int x) {
        int l=0,r=x,index=-1;
        while (l<=r){
            int mid = l+(r-1)/2;
            if((long)mid * mid<=x){
                index = mid;
                l=mid + 1;
            }else{
                r=mid-1;
            }
            return index;
        }
        return index;
    }




}
