package ai.yuhan.other.netty.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/10/15 16:05
 * @Version 1.0
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\Company_devops\\project\\strive\\strive-framework-demo\\target\\classes\\ai\\yuhan\\other\\netty\\nio\\1.txt","rw");
        //获取对应的通道
        FileChannel channel = randomAccessFile.getChannel();

        MappedByteBuffer mappedByteBuffer  = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0,(byte)'S');
        mappedByteBuffer.put(3,(byte)'9');
//        mappedByteBuffer.put(5,(byte)'Y');

        randomAccessFile.close();
        System.out.println("修改成功~~");

    }


}
