package com.liumapp.jspbasic.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by liumapp on 6/23/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class FileDemo {

    public static void main (String[] args) throws IOException {

        File file = new File("hello");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
        if (file.exists()) {
            file.delete();
        } else {
            file.mkdir();//file.mkdirs()创建多级目录
        }
        //如果为目录返回true，如果不是目录或者目录不存在，返回false
        System.out.println(file.isDirectory());
        //为文件返回true
        System.out.println(file.isFile());

        File file2 = new File("helloworld.txt");
        if (file2.exists()) {
            file2.delete();
        } else {
            file2.createNewFile();
        }


    }

}
