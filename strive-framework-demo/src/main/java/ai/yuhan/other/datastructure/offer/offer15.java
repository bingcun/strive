package ai.yuhan.other.datastructure.offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 * 提示：
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用 二进制补码 记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 * <p>
 * 示例 1：
 * 输入：n = 11 (控制台输入 00000000000000000000000000001011)
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * @author: bingcun.chen
 * @Date: 2021/6/27 16:50
 * @Version 1.0
 */
public class offer15 {
    public int hammingWeight(int n) {
        int res = 0;
        for(int i=1;i<=32;i++){
            if((n & (1 << i)) != 0){
                res++;
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(printNumbers(1)));


    }

    public int[] printNumbers(int n) {
        int res = 1;
        for (int i=0;i<n;i++){
            res = res * 10;
        }

        int[] result = new int[res - 1];
        res = 0;
        for(int i=0;i<= result.length -1;i++){
            result[i] = ++res ;
        }
        return result;
    }





}
