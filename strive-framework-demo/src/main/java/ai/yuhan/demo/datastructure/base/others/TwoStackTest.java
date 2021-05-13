package ai.yuhan.demo.datastructure.base.others;

/**
 * @Author: bingcun.chen
 * @Date: 2021/3/19 10:54
 * @Version: 1.0
 * @Email: 820306546@qq.com
 */
public class TwoStackTest {
    public static void main(String[] args) {
        TwoStack twoStack = new TwoStack();
        twoStack.push(1);
        twoStack.push(2);
        twoStack.push(3);
        twoStack.push(4);

        System.out.println(twoStack.pop());
        System.out.println(twoStack.pop());
        System.out.println(twoStack.pop());
        System.out.println(twoStack.pop());

//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//
//        System.out.println(stack.pop());
    }
}
