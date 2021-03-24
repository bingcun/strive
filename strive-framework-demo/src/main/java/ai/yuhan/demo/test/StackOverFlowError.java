package ai.yuhan.demo.test;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/13 9:29
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class StackOverFlowError {
    int depth = 0;
    public void sofmethod(){
        depth++;
        sofmethod();
    }
    public static void main(String[] args) {
        StackOverFlowError stackOverFlowError = new StackOverFlowError();
        stackOverFlowError.sofmethod();
    }
}
