package ai.yuhan.other.datastructure.careers.easy;

import java.util.ArrayList;

/**
 * @description: 设计getMin功能的栈
 * 题目描述
 * 实现一个特殊功能的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 输入:[[1,3],[1,2],[1,1],[3],[2],[3]]
 * 输出:[1,2]
 *
 * @author: bingcun.chen
 * @Date: 2021/5/17 18:41
 * @Version 1.0
 */
public class NC90 {


    /**
     * return a array which include all ans for op3
     * @param op int整型二维数组 operator
     * @return int整型一维数组
     */
    public int[] getMinStack (int[][] op) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0;i<op.length;i++){
            if (op[i][0] == 1){ // 入栈
                list.add(op[i][1]);
            }else if (op[i][0] == 2){
                list.remove(list.size()-1);
            }else if (op[i][0] == 3)
                res.add(getMin(list));
        }
        int [] arr = new int[res.size()];
        for (int i = 0;i< res.size();i++){
            arr[i] = res.get(i);
        }
        return arr;
    }


    public int getMin(ArrayList<Integer> list){
        int min = Integer.MAX_VALUE;
        for (int val : list){
            if (min > val)
                min = val;
        }
        return min;
    }
}
