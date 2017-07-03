package com.liumapp.jspbasic.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

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

            /**
             * 调用accept()方法开始监听，等待客户端的连接
             */
            System.out.println("等待客户连接");
            Socket socket = serverSocket.accept();

            /**
             * 获取输入流，并读取客户端信息
             */
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bf = new BufferedReader(isr);
            String info = null;
            while ((info = bf.readLine()) != null) {
                System.out.println("server获取到: " + info);
            }
            /**
             * 关闭输入流
             */
            socket.shutdownInput();

            /**
             * 获取输出流，响应客户端的请求
             */
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("欢迎登录");
            pw.flush();//输出

            /**
             * 关闭相关资源
             */
            pw.close();
            os.close();
            bf.close();
            isr.close();
            is.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
