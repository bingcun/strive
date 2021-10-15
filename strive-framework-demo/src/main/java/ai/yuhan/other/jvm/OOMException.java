package ai.yuhan.other.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/9/25 19:11
 * @Version 1.0
 */
public class OOMException {
    byte[] a = new byte[1024 * 100];

    public static void main(String[] args) throws InterruptedException {
        List<OOMException> list = new ArrayList<>();

        while (true){
            list.add(new OOMException());
            Thread.sleep(100);
        }
    }


}
