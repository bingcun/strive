package ai.yuhan.other.netty.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/10/10 11:41
 * @Version 1.0
 */
public class NIOFileChannel01 {

    //用channel方式去写入数据
    @Test
    public void test01() throws Exception {
        String str = "hello,尚硅谷";
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Company_devops\\project\\strive\\strive-framework-demo\\src\\main\\java\\ai\\yuhan\\other\\netty\\io\\dir\\file01.txt");
        //nio 的方式创建channel
        FileChannel fileChannel = fileOutputStream.getChannel();
        //分配一个缓存区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        byteBuffer.put(str.getBytes(StandardCharsets.UTF_8));
        byteBuffer.put("\n".getBytes(StandardCharsets.UTF_8));
        byteBuffer.put(str.getBytes(StandardCharsets.UTF_8));
        //反转读写
        byteBuffer.flip();
        //往channel里面写入byteBuffer
        fileChannel.write(byteBuffer);
        //关闭输出流
        fileOutputStream.close();
    }

    @Test
    public void test02() throws Exception {
        String str = "hello,尚硅谷";

        File file = new File("D:\\Company_devops\\project\\strive\\strive-framework-demo\\src\\main\\java\\ai\\yuhan\\other\\netty\\io\\dir\\file02.txt");

        FileOutputStream fos = new FileOutputStream(file);

        OutputStreamWriter ops = new OutputStreamWriter (fos,"utf-8");

        BufferedWriter bw = new BufferedWriter(ops);

        bw.write(str);

        bw.newLine();

        bw.flush();

        fos.close();

        bw.close();



    }

}
