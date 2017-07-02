package com.liumapp.jspbasic.io;

import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;

/**
 * Created by liumapp on 6/30/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class IOUtilTest extends TestCase {

    public void testPrintHex () {
        String path;
        path = this.getClass().getResource("/").getPath() + "/../classes/" + "testData";
        try {
            IOUtil.printHex(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        IOUtil.printHex();
    }

    public void testPrintHexByByteArray () {
        String path;
        path = this.getClass().getResource("/").getPath() + "/../classes/" + "testData";
        try {
            IOUtil.printHexByByteArray(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testFileOutDemo () {
        String path;
        path = this.getClass().getResource("/").getPath() + "/../classes/" + "testPutData";
        try {
            IOUtil.FileOutDemo(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testCopyFile () {
        String src , dest;
        src = this.getClass().getResource("/").getPath() + "/../classes/" + "testPutData";
        dest = this.getClass().getResource("/").getPath() + "/../classes/" + "testPutDataCopy";

        try {
            IOUtil.copyFile(new File(src) , new File(dest));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
