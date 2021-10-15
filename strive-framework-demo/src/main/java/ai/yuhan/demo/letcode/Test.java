package ai.yuhan.demo.letcode;

import java.io.BufferedReader;
import java.util.Arrays;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/9/29 14:36
 * @Version 1.0
 */
public class Test {

    @org.junit.Test
    public void test(){
        int[] machines = new int[]{0,3,0};
        int minMoves = findMinMoves(machines);
        System.out.println(minMoves);
    }
    public int findMinMoves(int[] machines) {
        int tot = Arrays.stream(machines).sum();
        int n = machines.length;
        if (tot % n != 0) {
            return -1;
        }
        int avg = tot / n;
        int ans = 0, sum = 0;
        for (int num : machines) {
            num -= avg;
            sum += num;
            ans = Math.max(ans, Math.max(Math.abs(sum), num));
        }
        //ans 1 sum -1 num -1
        //ans 2 sum  1 num  2
        //ans 2 sum  0 num -1
        return ans;
    }
}
