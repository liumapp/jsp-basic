package com.liumapp.jspbasic.socket;

import javafx.scene.chart.PieChart;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liumapp on 7/3/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 * 基于Tcp协议的Socket通信
 * 实现用户登录
 * 服务端
 */
public class Server {

    public static void main (String[] args) {

        try {
            /**
             * 创建一个服务器端socket
             * ServerSocket
             * 指定绑定的端口
             * 并监听此端口
             */
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket socket = null;
            int count = 0;//记录客户端的数量
            /**
             * 调用accept()方法开始监听，等待客户端的连接
             */
            System.out.println("等待客户连接");

            while(true) {
                socket = serverSocket.accept();
                //创建线程
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                count++;
                System.out.println("在" + new SimpleDateFormat("H:m:s").format(new Date()) + " 一共有： "  + count + "台客户端");
                System.out.println("新访问的IP为： " + socket.getInetAddress().getHostAddress());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
