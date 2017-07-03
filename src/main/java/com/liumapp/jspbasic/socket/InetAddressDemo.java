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

    }

}
