package ai.yuhan.other.datastructure.juide;

/**
 * @description: 变态青蛙跳台问题
 * @author: bingcun.chen
 * @Date: 2021/8/22 15:35
 * @Version 1.0
 */
public class Test3_3_10_02 {

    public int fib(int n){

        // 1 1
        // 2 2
        // 3 4
        // 4 8
        /**
         * 假设n>=2，第一步有n种跳法：跳1级、跳2级、到跳n级 跳1级，剩下n-1级，则剩下跳法是f(n-1) 跳2级，剩下n-2级，
         * 则剩下跳法是f(n-2) ...... 跳n-1级，剩下1级，则剩下跳法是f(1) 跳n级，剩下0级，则剩下跳法是f(0) 所以在n>=2的情况下：
         * f(n)=f(n-1)+f(n-2)+...+f(1) 因为f(n-1)=f(n-2)+f(n-3)+...+f(1) 所以f(n)=2*f(n-1) 又f(1)=1,
         * 所以可得f(n)=2^(number-1)
         */
        return 1 << --n;
    }

}
