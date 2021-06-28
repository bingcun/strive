package ai.yuhan.other.datastructure.offer;

/**
 * @description:
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 * @author: bingcun.chen
 * @Date: 2021/6/28 14:56
 * @Version 1.0
 */
public class offer65 {
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
}
