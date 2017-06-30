package com.liumapp.jspbasic.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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
            if (b <= 0xf) {
                //单位数前面补0
                System.out.print("0");
            }
            System.out.print(Integer.toHexString( b ) + " ");
            if (i++ % 10  == 0) {
                System.out.println();
            }
        }
        in.close();
    }

    public static void printHexByByteArray (String fileName) throws IOException {

        FileInputStream in = new FileInputStream(fileName);
        byte[] buf = new byte[ 20 * 1024] ; // 20kb

        /**
         * 往buf的起始位置开始存放
         * 最多存放数据不超过20kb
         * 返回的butes是读到的字节个数
         * 如果是一次性读取完，说明20kb足够存放，否则不够
         */
        /*int bytes = in.read(buf , 0 , buf.length);
        int j = 1;
        for (int i = 0 ; i < bytes ; i++) {
            if (buf[i] <= 0xf) {
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(buf[i]) + " ");
            if (j++ % 10  == 0) {
                System.out.println();
            }
        }*/


        /**
         * 当字节数组不够大的时候
         * 那就反复使用buf去读取
         */
        int bytes =  0;
        int j = 1;
        while ( (bytes = in.read(buf , 0 , buf.length)) != -1) {
            for (int i = 0 ; i < bytes ; i++) {
                if (buf[i] <= 0xf) {
                    System.out.print("0");
                }
                System.out.print(Integer.toHexString(buf[i]) + " ");
                if (j++ % 10  == 0) {
                    System.out.println();
                }
            }
        }

    }


    public static void FileOutDemo (String fileName) throws IOException {

        /**
         * 如果一个文件不存在，则直接创建，如果存在，删除后创建
         * 要注意这个类在构建的时候，如果添加一个true，那么结果就是在文件的后面进行追加
         */
        FileOutputStream out = new FileOutputStream(fileName);

        /**
         * 一次只能写一个字节
         * 将写入A的低八位
         */
        out.write('A');

        /**
         * 所以要写入一个int型的数，需要写四次
         */
        int a = 10;
        out.write(a >>> 24);
        out.write(a >>> 16);
        out.write(a >>> 8);
        out.write(a);

        byte[] utf8 = "中国" . getBytes("utf-8");
        out.write(utf8);
        out.close();

        IOUtil.printHex(fileName);
    }

}
