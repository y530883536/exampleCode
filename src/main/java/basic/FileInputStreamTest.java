package basic;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author yechangfeng
 * @date 2018/12/20
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws Exception{
        File file = new File("D:/bbb.jpg");
        FileInputStream fileInputStream = new FileInputStream(file);
        System.out.println(file.length());
    }
}
