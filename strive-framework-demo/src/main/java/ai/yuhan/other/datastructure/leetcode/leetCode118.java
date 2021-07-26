package ai.yuhan.other.datastructure.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/7/19 18:05
 * @Version 1.0
 */
public class leetCode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows >= 1){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            result.add(list);
        }

        if(numRows >= 2){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            result.add(list);
        }

        int[][] dp = new int[numRows + 1][numRows + 1];
        dp[1][1] = 1;

        dp[2][1] = 1;
        dp[2][2] = 1;


        for (int i = 3; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 2; j <= i - 1; j++) {
                dp[i][j] += dp[i - 1][j - 1] + dp[i - 1][j];
                list.add(dp[i][j]);
            }
            list.add(1);
            result.add(list);
        }

        return result;
    }


    public List<List<Integer>> generate01(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }



    @Test
    public void test() {
        int i = translateNum(123);
        Set set = new HashSet();

    }
    public int translateNum(int num) {
        String src = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.length(); ++i) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }

}
