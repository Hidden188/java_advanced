package nioDemo;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NioTest {

    @Test
    public void testChannel() {
        long startTime = System.currentTimeMillis();
        try {
            FileChannel inputFileChannel = FileChannel.open(Paths.get("D://BaiduNetdiskDownload/0806.mp4"), StandardOpenOption.READ);
            FileChannel outFileChannel = FileChannel.open(Paths.get("D://BaiduNetdiskDownload/08061.mp4"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            // 映射文件
            MappedByteBuffer inputMappedByteBuffer = inputFileChannel.map(FileChannel.MapMode.READ_ONLY, 0, inputFileChannel.size());
            MappedByteBuffer outMappedByteBuffer = outFileChannel.map(FileChannel.MapMode.READ_WRITE, 0, inputFileChannel.size());
            // 直接对缓冲区进行数据读写操作
            byte[] dst = new byte[inputMappedByteBuffer.limit()];
            inputMappedByteBuffer.get(dst);
            outMappedByteBuffer.put(dst);
            outFileChannel.close();
            inputFileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 结束
        long endTime = System.currentTimeMillis();
        System.out.println("内存映射文件耗时：" + (endTime - startTime));
    }

    @Test
    public void testStream() {
        long startTime = System.currentTimeMillis();
        // 非直接缓冲区
        try {
            FileInputStream fileInputStream = new FileInputStream("D://BaiduNetdiskDownload/0806.mp4");
            FileOutputStream fileOutputStream = new FileOutputStream("D://BaiduNetdiskDownload/08062.mp4");
            // 获取通道
            FileChannel inFileChannel = fileInputStream.getChannel();
            FileChannel outFileChannel = fileOutputStream.getChannel();
            // 分配指定大小的缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (inFileChannel.read(byteBuffer) != -1) {
                byteBuffer.flip(); // 切换到读取模式
                outFileChannel.write(byteBuffer);
                byteBuffer.clear(); // 清空缓冲区
            }
            // 关闭连接
            outFileChannel.close();
            inFileChannel.close();
            fileOutputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 结束
        long endTime = System.currentTimeMillis();
        System.out.println("内存映射文件耗时：" + (endTime - startTime));
    }
}
