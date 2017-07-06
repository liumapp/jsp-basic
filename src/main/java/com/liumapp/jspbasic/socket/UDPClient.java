package com.liumapp.jspbasic.socket;

import java.io.IOException;
import java.net.*;

/**
 * Created by liumapp on 7/4/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class UDPClient {

    public static void main (String[] args) throws IOException {
        /**
         * 定义服务器的地址
         * 端口号
         * 数据
         */
        InetAddress address = InetAddress.getByName("localhost");
        int port = 9999;
        byte[] data = "用户名：admin;密码：123".getBytes();

        /**
         * 创建数据报
         * 包含发送的数据信息
         */
        DatagramPacket packet = new DatagramPacket(data , data.length , address , port);

        /**
         * 创建DatagramSocket
         */
        DatagramSocket socket = new DatagramSocket();

        /**
         * 向服务器端发送数据报
         */
        socket.send(packet);

        /**
         * 接受server端响应的数据
         * 创建一个数据报用于接受数据
         */
        byte[] data2 = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(data2 , data2.length);
        /**
         * 接受服务器响应的数据
         */
        socket.receive(packet2);
        /**
         * 读取数据
         */
        String reply = new String(data2 , 0 , packet2.getLength());
        System.out.println("client , get data : " + reply);

        /**
         * 关闭资源
         */
        socket.close();


    }

}
