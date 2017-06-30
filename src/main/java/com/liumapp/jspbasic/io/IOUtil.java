package com.liumapp.jspbasic.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by liumapp on 6/30/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class IOUtil {

    /**
     * 读取指定文件内容，按照16进制输出到控制台
     * 并且每输出10个byte换行
     * @param fileName
     */
    public static void printHex(String fileName) throws IOException{
        // 把文件作为字节流进行读操作
        FileInputStream in = new FileInputStream(fileName);
        int b ;
        int i = 1;
        while( (b = in.read()) != -1) {
            System.out.print(Integer.toHexString( b ) + "");
            if (i++ % 10  == 0) {
                System.out.println();
            }
        }
        in.close();
    }

}
