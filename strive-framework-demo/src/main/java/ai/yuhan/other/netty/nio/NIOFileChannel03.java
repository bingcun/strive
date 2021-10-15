package ai.yuhan.other.netty.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/10/15 14:19
 * @Version 1.0
 */
public class NIOFileChannel03 {

    public static void main(String[] args) throws Exception {
        //输入流
        FileInputStream fileInputStream = new FileInputStream("D:\\Company_devops\\project\\strive\\strive-framework-demo\\target\\classes\\ai\\yuhan\\other\\netty\\nio\\1.txt");
        FileChannel fileChannel01 = fileInputStream.getChannel();

        //输出流
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Company_devops\\project\\strive\\strive-framework-demo\\target\\classes\\ai\\yuhan\\other\\netty\\nio\\2.txt");
        FileChannel fileChannel02 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true){
            byteBuffer.clear();
            int read = fileChannel01.read(byteBuffer);
            System.out.println(" read = " + read);
            if(read == -1){
                break;
            }

            byteBuffer.flip();
            fileChannel02.write(byteBuffer);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
