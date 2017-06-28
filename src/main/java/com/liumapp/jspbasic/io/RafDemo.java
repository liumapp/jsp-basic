package com.liumapp.jspbasic.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

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

    }

}
