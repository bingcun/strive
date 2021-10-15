package ai.yuhan.other.jvm;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/9/25 20:02
 * @Version 1.0
 */
public class OutOfStackException {

    public static void test(){
        test();
    }

    public static void main(String[] args) {
        test();
    }

}
