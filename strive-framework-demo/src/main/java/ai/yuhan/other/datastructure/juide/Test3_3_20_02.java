package ai.yuhan.other.datastructure.juide;

import org.junit.Test;

import java.util.Stack;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/8/23 9:58
 * @Version 1.0
 */
public class Test3_3_20_02 {

    /**
     * 入栈1,2,3,4,5   出栈4,5,3,2,1
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed,int[] popped){
        if(pushed.length == 0 && popped.length ==0){
            return true;
        }

        if(pushed.length == 0 || popped.length ==0){
            return false;
        }
        int totalIndex = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < pushed.length;i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[totalIndex]){
                stack.pop();
                totalIndex++;
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test(){
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,5,3,2,1};

        System.out.println(validateStackSequences(pushed, popped));

    }

}
