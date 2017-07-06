package com.liumapp.jspbasic.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by liumapp on 7/4/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 * 实现基于UDP的用户登录
 */
public class UDPServer {

    public static void main (String[] args) throws IOException {
        /**
         * 接受client数据
         */
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] data = new byte[20 * 1024];
        DatagramPacket packet = new DatagramPacket(data , data.length);

        /**
         * 接受客户端的数据
         * 在接收到数据之前会一直处于阻塞状态
         */
        System.out.println("server即将启动");
        socket.receive(packet);

        String info = new String(data , 0 , packet.getLength());
        System.out.println("server data : " + info);

        /**
         * 向client响应数据
         * 定义客户端的地址、端口号和数据
         */
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        byte[] data2 = "欢迎您" . getBytes();

        /**
         * 创建数据报
         * 包含响应的数据信息
         */
        DatagramPacket packet2 = new DatagramPacket(data2 , data2.length ,  address , port);

        /**
         * 响应客户端
         */
        socket.send(packet2);

        /**
         * 关闭资源
         */
        socket.close();

    }

}
