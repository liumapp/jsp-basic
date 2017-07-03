package com.liumapp.jspbasic.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by liumapp on 7/3/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class UrlDemo {

    public static void childUrl () throws MalformedURLException {
        URL liumapp = new URL("http://www.liumapp.com");
        URL childUrl = new URL(liumapp , "/articles/2017/06/28/1498636906233.html?username=add#test");
        System.out.println("子URL的协议： " + childUrl.getProtocol());
        System.out.println("主机： " + childUrl.getHost());

        /**
         * 如果未指定端口号，则使用协议默认的端口号，http默认对应80端口，而此时getPort的返回值为－1
         */
        System.out.println("端口号: " + childUrl.getPort());
        System.out.println("文件路径： " + childUrl.getPath());
        System.out.println("文件名： " + childUrl.getFile());
        System.out.println("相对路径: " + childUrl.getRef());
        System.out.println("查询字符串: " + childUrl.getQuery());
    }

    public static void readStream () throws IOException {
        String data;
        URL url = new URL("http://www.liumapp.com");
        //通过openStream方法获取url对象所表示的资源的字节输入流
        InputStream is = url.openStream();
        //将字节输入流转换为字符输入流
        InputStreamReader isr = new InputStreamReader(is , "utf-8");
        //为字符输入流添加缓冲
        BufferedReader br = new BufferedReader(isr);
        while((data = br.readLine()) != null) {
            System.out.println(data);
        }
        br.close();
        isr.close();
        is.close();

    }

}
