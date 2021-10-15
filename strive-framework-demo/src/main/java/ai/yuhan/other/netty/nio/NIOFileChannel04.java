package ai.yuhan.other.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/10/15 15:01
 * @Version 1.0
 */
public class NIOFileChannel04 {
    public static void main(String[] args) throws Exception {

        FileInputStream fileInputStream = new FileInputStream("D:\\Company_devops\\project\\strive\\strive-framework-demo\\target\\classes\\ai\\yuhan\\other\\netty\\nio\\1.png");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Company_devops\\project\\strive\\strive-framework-demo\\target\\classes\\ai\\yuhan\\other\\netty\\nio\\2.png");

        FileChannel fileChannel01 = fileInputStream.getChannel();
        FileChannel fileChannel02 = fileOutputStream.getChannel();

        //使用transferForm进行拷贝
        fileChannel02.transferFrom(fileChannel01,0,fileChannel01.size());

        //关闭相关通道和流
        fileChannel01.close();
        fileChannel02.close();

        fileInputStream.close();
        fileOutputStream.close();
    }

}
