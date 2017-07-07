package com.liumapp.jspbasic.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by liumapp on 7/3/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class InetAddressDemo {

    public static void localHost () throws UnknownHostException {

        InetAddress address = InetAddress.getLocalHost();
        System.out.println("计算机名：" + address.getHostName());
        System.out.println("IP地址：" + address.getHostAddress());

        byte[] ipArray = address.getAddress();
        System.out.println("已字节数组形式返回的ip：" + ipArray);

        System.out.println("直接返回对象：" + address);

        InetAddress address2 = InetAddress.getByName("106.14.212.41");//获取网络上的计算机信息
        System.out.println("网络上的一台计算机名称：" + address2.getHostName());
        System.out.println("它的IP地址：" + address2.getHostAddress());

    }

}
