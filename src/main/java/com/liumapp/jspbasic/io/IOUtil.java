package com.liumapp.jspbasic.io;

import java.io.*;

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

    /**
     * 将src文件的内容复制到dest文件里
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFile (File srcFile , File destFile) throws IOException {

        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件 " + srcFile + "不存在");
        }

        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }

        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);

        byte[] buf = new byte[8 * 1024];
        int b ;
        while ((b = in.read(buf , 0 , buf.length)) != -1) {
            out.write(buf , 0 , b);
        }
        out.flush();//flush()作用是将缓冲区内容强制写出，避免文件未写完就关闭了，所以一般在文件关闭之前加上这句
        in.close();
        out.close();
    }

    /**
     * 利用缓冲字节流进行文件的拷贝
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByBuffer (File srcFile , File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件 " + srcFile + "不存在");
        }

        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }

        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(srcFile)
        );
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(destFile)
        );
        int c;
        while((c = bis.read()) != -1) {
            bos.write(c);
        }
        bos.flush();//刷新缓冲区，把里面的数据写出到destFile
        bis.close();
        bos.close();
    }

    public static void DosDemo (String fileName) throws IOException {

        DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName));
        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeLong(100);
        dos.writeByte(1000);
        dos.writeDouble(10.5);
        dos.writeUTF("世界你好");//utf-8
        dos.writeChars("世界你好");//utf-16
        dos.close();
        IOUtil.printHex(fileName);

    }

    public static void DisDemo (String fileName) throws IOException {

        IOUtil.printHex(fileName);
        DataInputStream dis = new DataInputStream(new FileInputStream(fileName));
        int i = dis.readInt();
        int i2 = dis.readInt();
        System.out.println("read int data is : " + i + " and " + i2);
        long l = dis.readLong();
        System.out.println("read long data is : " + l);
        Byte b = dis.readByte();
        System.out.println("read byte data is : " + b);
        Double d = dis.readDouble();
        System.out.println("read double data is : " + d);
        String s = dis.readUTF();
        System.out.println("read utf8 data is : " + s);
        dis.close();
    }

    public static void IsrAndOswDemo (String fileName , String outFileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(in , "utf-8");

        FileOutputStream out = new FileOutputStream(outFileName);
        OutputStreamWriter osw = new OutputStreamWriter(out , "utf-8");
        /*
        int c;
        while((c = isr.read()) != -1) {
            System.out.println((char)c);
        }
        */
        char[] buffer = new char[8 * 1024];
        int c;
        /**
         * 批量读取
         * 从第0个位置开始放入buffer
         * 最多buffer.length个
         * 返回的是读到的字符的个数
         */
        while ((c = isr.read(buffer , 0 , buffer.length)) != -1){
            String s = new String(buffer , 0 , c );
            System.out.println(s);
            osw.write(buffer , 0 , c);
        }
        osw.flush();

        osw.close();
        isr.close();
    }



}
