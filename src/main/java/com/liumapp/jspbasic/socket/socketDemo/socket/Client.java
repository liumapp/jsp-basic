package com.liumapp.jspbasic.socket.socketDemo.socket;

import com.liumapp.jspbasic.socket.socketDemo.entity.FileEntity;
import com.liumapp.jspbasic.socket.socketDemo.entity.User;
import com.liumapp.jspbasic.socket.socketDemo.util.CommandRelay;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by liumapp on 7/7/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class Client {

    String username = null;
    String password = null;
    Socket socket = null;
    User user = new User();
    FileEntity fe = null;
    Scanner input = new Scanner(System.in);

    /**
     * 发送对象
     * @param cr
     */
    public void sendData (CommandRelay cr) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(cr);
        oos.flush();
    }

    /**
     * 接收对象
     * @return
     * @throws Exception
     */
    public CommandRelay getData() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        CommandRelay cr = (CommandRelay) ois.readObject();
        return cr;
    }

    public void login() throws Exception {
        System.out.println("ready login:");
        int count = 0 ;
        CommandRelay cr = new CommandRelay();
        while (true) {
            System.out.print("enter your account:");
            username = input.next();
            user.setUsername(username);
            System.out.print("enter your password:");
            user.setPassword(input.next());
            count++;
            if (count == 3) {
                System.out.println("password error for 3 times , system shutdown");
                System.exit(0);
            }
            cr.setCommand("login");
            cr.setUserObject(user);
            socket = new Socket("localhost" , 9999);
            sendData(cr);
            cr = getData();
            if (cr.isFlag()) {
                break;
            } else {
                System.out.println("account or password error ! plz try again");
                continue;
            }
        }
        System.out.println("登录成功，进入文件上传下载器");
        fileMain();
    }

    public void register() throws Exception {

        System.out.println("***********开始注册账号***********");
        String confirm = null;
        CommandRelay cr = new CommandRelay();
        while (true) {

            System.out.print("请输入账号：");
            username = input.next();
            System.out.print("请输入密码：");
            password = input.next();
            System.out.print("请再次输入密码：");
            confirm = input.next();
            if (!password.equals(confirm)) {
                System.out.println("两次输入的密码不一样，请重新输入！");
                continue;
            }
            user.setUsername(username);
            user.setPassword(password);
            cr.setCommand("register");
            cr.setUserObject(user);
            socket = new Socket("localhost" , 9999);
            sendData(cr);
            cr = getData();
            if (cr.isFlag()) {
                break;
            } else {
                System.out.println("注册失败！");
                continue;
            }
        }
        System.out.println("注册成功请登录！");
        login();

    }

    /**
     * 文件上传
     * @throws Exception
     */
    public void upload () throws Exception {

        System.out.println("**************上传文件******************");
        System.out.println("****************请输入上传文件路径（绝对路径：/usr/local/text.dat）******************");
        String filename = input.next();
        FileInputStream fis = new FileInputStream(filename);
        byte[] fileBytes = new byte[fis.available()];
        BufferedInputStream bis = new BufferedInputStream(fis);
        bis.read(fileBytes);

        FileEntity fe = new FileEntity();
        fe.setUserName(username);
        fe.setFileName(filename);
        fe.setFileContent(fileBytes);

        CommandRelay cr = new CommandRelay();
        cr.setCommand("upload");
        cr.setFileObject(fe);

        socket = new Socket("localhost" , 9999);
        sendData(cr);

        cr = getData();
        if (cr.isFlag()) {
            System.out.println("上传成功，返回主界面！");

        } else {
            System.out.println("上传失败，请重新上传！");
        }

        fileMain();
        close();

    }

    /**
     * 文件查看
     * @throws Exception
     */
    public void view () throws Exception {
        System.out.println("*******查看文件*********");
        FileEntity fe = new FileEntity();
        fe.setUserName(username);

        CommandRelay cr = new CommandRelay();
        cr.setCommand("view");
        cr.setFileObject(fe);

        socket = new Socket("localhost" , 9999);
        sendData(cr);

        cr = getData();
        if (cr.isFlag()) {
            ArrayList<FileEntity> fileList = cr.getFileList();
            System.out.println("编号\t文件名");
            for (FileEntity fileEntity : fileList) {
                System.out.println(fileEntity);
            }
        } else {
            System.out.println("没有文件，还未上传文件！");
        }
        fileMain();
        close();
    }

    /**
     * 下载文件
     * @throws Exception
     */
    public void download () throws Exception {
        System.out.println("******下载文件*******");
        System.out.println("请输入要下载文件的编号: ");
        FileEntity fe = new FileEntity();
        fe.setId(input.nextInt());
        System.out.println("请输入下载路径：(如/usr/local/src.dat)");

        String filename = input.next();
        CommandRelay cr = new CommandRelay();
        cr.setCommand("download");
        cr.setFileObject(fe);

        socket = new Socket("localhost" , 9999);
        sendData(cr);

        cr = getData();
        if (cr.isFlag()) {
            byte[] bytes = cr.getBytes();
            FileOutputStream out = new FileOutputStream(filename);
            out.write(bytes);
            System.out.println("下载成功！");
            out.close();
        } else {
            System.out.println("下载失败！");
        }

        fileMain();
        close();
    }

    public void delete() throws Exception {
        System.out.println("*******删除文件**********");
        System.out.println("请输入要删除的文件编号");
        FileEntity fe = new FileEntity();
        fe.setId(input.nextInt());
        CommandRelay cr = new CommandRelay();
        cr.setCommand("delete");
        cr.setFileObject(fe);

        socket = new Socket("localhost" , 9999);
        sendData(cr);

        cr = getData();
        if (cr.isFlag()) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
        fileMain();
        close();
    }

    public void close () {
        input.close();
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileMain() throws Exception {
        System.out.println("*****文件上传下载器******");
        System.out.print("1.上传\n2.下载\n3.查看\n4.删除\n5.退出\n请输入: ");
        String flag = null;
        while (true) {
            flag = input.next();
            switch (flag) {
                case "1" :
                    upload();
                    break;
                case "2":
                    download();
                    break;
                case "3":
                    view();
                    break;
                case "4":
                    delete();
                    break;
                case "5":
                    System.out.println("bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("指令不正确，请重新输入");
                    continue;
            }
            break;
        }
    }

    public static void main (String[] args) throws Exception {
        Client client = new Client();
        System.out.println("*********欢迎使用文件上传下载器***********");
        String flag = null;
        while (true) {
            System.out.println("1.登陆\\n2.注册\\n3.退出\\n请输入: \n");
            flag = client.input.next();
            switch (flag) {
                case "1" :
                    client.login();
                    break;
                case "2":
                    client.register();
                    break;
                case "3":
                    System.out.println("bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("指令不正确，请重新输入");
                    continue;
            }
            break;
        }
    }


}
