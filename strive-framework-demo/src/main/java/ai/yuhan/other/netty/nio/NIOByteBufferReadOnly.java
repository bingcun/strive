package ai.yuhan.other.netty.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/10/15 15:22
 * @Version 1.0
 */
public class NIOByteBufferReadOnly {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(64);

        for (int i = 0;i < 64;i++){
            buffer.put((byte)i);
        }

        buffer.flip();

        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());

        while (readOnlyBuffer.hasRemaining()){
            System.out.println(readOnlyBuffer.get());
        }

        readOnlyBuffer.put((byte) 100);


    }



}
