package com.liumapp.jspbasic.socket.socketDemo.service;


import com.liumapp.jspbasic.socket.socketDemo.socket.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by liumapp on 7/7/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class Server {

    public static void main (String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9999);
        Socket socket = null;
        System.out.println("server begin：");
        while (true) {
            socket = ss.accept();
            ServerThread st = new ServerThread(socket);
            st.start();
        }


    }

}
