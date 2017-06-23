package com.liumapp.jspbasic.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by liumapp on 6/23/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class FileUtil {

    public static void listDirectory (File dir) throws IOException {
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录" + dir + "不存在");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + "不是目录");
        }

        String[] filenames = dir.list();
        for (String string: filenames) {
            System.out.println(string);
        }
    }

}
