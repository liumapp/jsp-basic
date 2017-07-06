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

    public void testCopyFileByBuffer () {
        String src , dest;
        src = this.getClass().getResource("/").getPath() + "/../classes/" + "testPutData";
        dest = this.getClass().getResource("/").getPath() + "/../classes/" + "testPutDataCopy";

        try {

            IOUtil.copyFileByBuffer(new File(src) , new File(dest));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testDosDemo () {
        String path;
        path = this.getClass().getResource("/").getPath() + "/../classes/" + "testPutData";
        try {
            IOUtil.DosDemo(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testDisDemo () {
        String path;
        path = this.getClass().getResource("/").getPath() + "/../classes/" + "testPutData";
        try {
            IOUtil.DisDemo(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testIsrAndOswDemo () {
        String path , outPath;
        path = this.getClass().getResource("/").getPath() + "/../classes/" + "testPutData";
        outPath = this.getClass().getResource("/").getPath() + "/../classes/" + "OswCopyData";
        try {
            IOUtil.IsrAndOswDemo(path , outPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testFrAndFwDemo () {
        String path , outPath;
        path = this.getClass().getResource("/").getPath() + "/../classes/" + "testPutData";
        outPath = this.getClass().getResource("/").getPath() + "/../classes/" + "OswCopyData";
        try {
            IOUtil.FrAndFwDemo(path , outPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testBrAndBwOrPwDemo () {
        String path , outPath;
        path = this.getClass().getResource("/").getPath() + "/../classes/" + "testPutData";
        outPath = this.getClass().getResource("/").getPath() + "/../classes/" + "OswCopyData";
        try {
            IOUtil.BrAndBwOrPwDemo(path , outPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
