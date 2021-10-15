package ai.yuhan.other.datastructure.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/8/2 9:49
 * @Version 1.0
 */
public class leetCode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }

        for(int j=0;j<prerequisites.length;j++){
            int end = prerequisites[j][0];
            int start = prerequisites[j][1];

            list.get(start).add(end);
        }

        int[] flag = new int[numCourses];

        for(int i = 0;i < numCourses;i++){
            if(dfs(list,flag,i)){
                return false;
            }
        }


        return true;
    }

    private boolean dfs(List<List<Integer>> list,int[] flag,int index){
        if(flag[index] == 1)return true;
        if(flag[index] == -1)return false;

        flag[index] = 1;
        for(Integer ss:list.get(index)){
            if(dfs(list,flag,ss)){
                return true;
            }
        }

        flag[index] = -1;
        return false;
    }

    @Test
    public void test(){
        int[][] data = {{0,2},{1,0},{2,1}};
        boolean b = canFinish(3, data);
        System.out.println(b);
//        System.out.println("123456");

    }

}
