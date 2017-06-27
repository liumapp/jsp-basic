package com.liumapp.jspbasic.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by liumapp on 6/23/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class FileUtil {

    /**
     * 递归遍历一个目录，然后输出其下的所有文件和目录
     * @param dir
     * @throws IOException
     */
    public static void listDirectory (File dir) throws IOException {
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录" + dir + "不存在");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + "不是目录");
        }
//      获取dir目录下的子元素
//        String[] filenames = dir.list();
//        for (String string: filenames) {
//            System.out.println(string);
//        }

        /**
         * 如果要遍历子目录下的内容就需要构造成File对象做递归操作。
         */
        File[] files = dir.listFiles();//返回的是直接子目录（或者文件）的抽象
        if (files != null && files.length > 0 ) {
            for (File file : files) {
                if (file.isDirectory()) {
                    //递归
                    listDirectory(file);
                } else {
                    System.out.println(file);
                }
            }
        }
    }

}
