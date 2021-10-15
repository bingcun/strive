package ai.yuhan.other.netty.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/10/14 17:35
 * @Version 1.0
 */
public class NIOFileChannel02 {
    public static final String path = "D:\\Company_devops\\project\\strive\\strive-framework-demo\\src\\main\\java\\ai\\yuhan\\other\\netty\\io\\dir\\file01.txt";

    public static void main(String[] args) throws Exception {
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);

        //通过fileInputStream获取对应的FileChannel->实际类型FileChannelImpl
        FileChannel fileChannel = fileInputStream.getChannel();

        //创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());

        //将通道的数据读入buffer
        fileChannel.read(byteBuffer);

        //将 byteBuffer 的字节数据转成 String
        System.out.println(new String(byteBuffer.array()));

        fileInputStream.close();
    }

}
