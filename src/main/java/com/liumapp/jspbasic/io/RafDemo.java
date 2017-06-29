package com.liumapp.jspbasic.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * Created by liumapp on 6/28/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class RafDemo {

    public static void main (String[] args) throws IOException {
        File demo = new File("demo");
        File file = new File( demo , "raf.dat" );
        if (!demo.exists()) {
            demo.mkdir();
        }

        if (!file.exists()) {
            file.createNewFile();
        }

        RandomAccessFile raf = new RandomAccessFile(file , "rw");
        System.out.println(raf.getFilePointer());
        raf.write('A');
        System.out.println(raf.getFilePointer());
        raf.write('B');
        System.out.println(raf.getFilePointer());

        int i = 0x7fffffff;//8位的16进制数，每两位就要占用一个字节
        System.out.println(i);
        //用write方法每次只能写一个字节，如果要把i写进去需要分四次写
        raf.write( i >>> 24);//高8位
        raf.write( i >>> 16);
        raf.write( i >>> 8);
        raf.write( i);
        System.out.println(raf.getFilePointer());

        //可以直接写一个int类型的数，但其底层的实现跟上面的写法一样
        raf.writeInt(i);
        System.out.println(raf.getFilePointer());

        String s = "中";
        byte[] utf8 = s.getBytes("utf-8");//编码上，utf-8中，一个汉字占3个字节
        raf.write(utf8);
        System.out.println(raf.getFilePointer());

        //读文件，把指针移到头部开始读
        raf.seek(0);
        //把文件内容一次性读取到字节数组中
        byte[] buf =  new byte[(int)raf.length()];
        raf.read(buf);
        System.out.println(Arrays.toString(buf));

        /**
         * 这样的输出方式将会导致乱码
         */
        String s1 = new String(buf , "utf-8");
        System.out.println(s1);

        for (byte b : buf) {
            System.out.print(Integer.toHexString( b & 0xff) + " ");
        }

        raf.close();
    }

}
