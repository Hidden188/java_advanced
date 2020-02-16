package interviewQuestions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MineFile {

    public static void main(String[] args) {
        String content = readFileByBtyes("D://testImg.png");
        //System.out.println(content);
        readAndWriteImg();
    }

    // 将乘法口诀表写入文件File到“D://test file.txt”中
    public void writeIn() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D://test file.txt")));
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= i; j++) {
                    bw.write(i + "*" + j + "=" + (i * j) + "\t");
                }
                bw.write("\r\n");
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 创建文件
    public static boolean createFiles(String filePath) {
        boolean result = false;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                result = file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    // 创建文件夹
    public static boolean createDirectory(String directory) {
        boolean result = false;
        File file = new File(directory);
        if (!file.exists()) {
            result = file.mkdirs();
        }
        return result;
    }

    // 删除文件
    public static boolean deleteFile(String filePath) {
        boolean result = false;
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            result = file.delete();
        }
        return result;
    }

    // 删除文件夹
    public static void deleteDirectory(String directoryPath) {
        File file = new File(directoryPath);
        if (!file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File tempFile : files) {
                deleteDirectory(directoryPath + "/" + tempFile.getName());
            }
            file.delete();
        }
    }

    // 图片的读取和写入
    public static void readAndWriteImg() {
        File originalFile = new File("D:\\dabai.jpg");//指定要读取的图片
        try {
            File result = new File("D:\\test0\\dabai.jpg");//要写入的图片
            if (result.exists()) {//校验该文件是否已存在
                result.delete();//删除对应的文件，从磁盘中删除
                result = new File("D:\\test0\\dabai.jpg");//只是创建了一个File对象，并没有在磁盘下创建文件
            }
            if (!result.exists()) {//如果文件不存在
                result.createNewFile();//会在磁盘下创建文件，但此时大小为0K
            }
            FileInputStream in = new FileInputStream(originalFile);
            FileOutputStream out = new FileOutputStream(result);// 指定要写入的图片
            int n = 0;// 每次读取的字节长度
            byte[] bb = new byte[1024];// 存储每次读取的内容
            while ((n = in.read(bb)) != -1) {
                out.write(bb, 0, n);// 将读取的内容，写入到输出流当中
            }
            //执行完以上后，磁盘下的该文件才完整，大小是实际大小
            out.close();// 关闭输入输出流
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取文件 1.以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件
     * 
     * @param filePath
     * @return
     * @author Ma.jian
     */
    public static String readFileByBtyes(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        StringBuilder content = new StringBuilder();
        try {
            byte[] temp = new byte[1024];
            FileInputStream fileInputStream = new FileInputStream(file);
            while (fileInputStream.read(temp) != -1) {
                content.append(new String(temp));
                temp = new byte[1024];
            }
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    /**
     * 读取文件 2.以字符为单位读取文件，常用于读文本，数字等类型的文件，支持读取中文
     * 
     * @param filePath
     * @return
     * @author Ma.jian
     */
    public static String readFileByChars(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        StringBuilder content = new StringBuilder();
        try {
            char[] temp = new char[1024];
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
            while (inputStreamReader.read(temp) != -1) {
                content.append(new String(temp));
                temp = new char[1024];
            }
            fileInputStream.close();
            inputStreamReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    //

}
