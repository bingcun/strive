package ai.yuhan.other.netty.nio;

import java.nio.ByteBuffer;

/**
 * @description:
 * ByteBuffer 支持类型化的 put 和 get，put 放入的是什么数据类型，get 就应该使用相应的数据类型来取出，
 * 否则可能有 BufferUnderflowException 异常。【举例说明】
 * @author: bingcun.chen
 * @Date: 2021/10/15 15:16
 * @Version 1.0
 */
public class NIOByteBufferPutGet {
    public static void main(String[] args) {
        //创建一个buffer
        ByteBuffer buffer = ByteBuffer.allocate(64);

        buffer.putInt(100);
        buffer.putLong(9);
        buffer.putChar('尚');
        buffer.putDouble(15.6);

        //反转缓冲流
        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getDouble());





    }

}
