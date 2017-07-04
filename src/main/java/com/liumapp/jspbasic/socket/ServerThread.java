package com.liumapp.jspbasic.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by liumapp on 7/3/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 * server端线程处理类
 */
public class ServerThread extends Thread {
    private Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader bf = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            /**
             * 获取输入流，并读取客户端信息
             */
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            bf = new BufferedReader(isr);
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
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎登录");
            pw.flush();//输出


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /**
             * 关闭相关资源
             */
            try {
                if (pw != null)
                    pw.close();
                if (os != null)
                    os.close();
                if (bf != null)
                    bf.close();
                if (isr != null)
                    isr.close();
                if (is != null)
                    is.close();
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
