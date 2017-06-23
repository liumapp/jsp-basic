package com.liumapp.jspbasic.io;

import java.io.UnsupportedEncodingException;

/**
 * Created by liumapp on 6/23/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class Encode{

    public static void main (String[] args) throws UnsupportedEncodingException {
        String s = "hello世界";

        //项目的默认编码
        byte[] bytes1 = s.getBytes();
        for (byte b:bytes1){
            //把字节转换成int，以16进制的方式显示
            System.out.print(Integer.toHexString(b) + "  ");
        }
        System.out.println();

        //gbk编码，一个英文一个字节，一个中文两个字节
        byte[] bytes2 = s.getBytes("gbk");
        for (byte b:bytes2){
            //把字节转换成int，以16进制的方式显示
            System.out.print(Integer.toHexString(b) + "  ");
        }
        System.out.println();

        //utf-8编码，一个英文一个字节，一个中文三个字节
        byte[] bytes3 = s.getBytes("utf-8");
        for (byte b:bytes3){
            //把字节转换成int，以16进制的方式显示
            System.out.print(Integer.toHexString(b) + "  ");
        }
        System.out.println();

        //java是双字节编码，及utf-16be
        //utf-16be中一个中文占用两个字节，一个英文占用两个字节。
        byte[] bytes4 = s.getBytes("utf-16be");
        for (byte b:bytes4){
            //把字节转换成int，以16进制的方式显示
            System.out.print(Integer.toHexString(b) + "  ");
        }
        System.out.println();

        /**
         * 当你的字节序列是某种编码时，这个时候想把字节序列变成字符串，也需要用这种编码方式，否则会出现乱码
         */
        String str1 = new String(bytes4);//使用项目默认编码，一般为utf-8
        System.out.println(str1);//应该会出现乱码
        String str2 = new String(bytes4 , "utf-16be");
        System.out.println(str2);
    }

}
