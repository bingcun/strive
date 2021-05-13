package ai.yuhan.demo.datastructure.careers.easy;

import org.junit.Test;

import java.util.Date;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/5/13 10:14
 * @Version 1.0
 */
public class NC47_1 {


    /**
     * 斐波那契数列--递归算法测试数据
     * @return
     */
    public int solutionFibonacci01(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else {
            return solutionFibonacci01(n-1) + solutionFibonacci01(n-2);
        }
    }

    /**
     * 斐波那契数列--递归算法
     * @return
     */
    public int solutionFibonacci02(int n){

        if(n==0)return 0;
        if(n==1)return 1;

        int result[] = new int[n+1];
        result[0] = 0;
        result[1] = 1;

        for(int i=2;i<=n;i++){
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }

    @Test
    public void test01(){
        long startTime = System.currentTimeMillis();
        System.out.println(solutionFibonacci01(100));
        long endTime = System.currentTimeMillis();
        System.out.println("当前花费的时间是:"+ (endTime-startTime)/1000);

    }

    @Test
    public void test02(){
        System.out.println(solutionFibonacci02(1000));
    }




}
