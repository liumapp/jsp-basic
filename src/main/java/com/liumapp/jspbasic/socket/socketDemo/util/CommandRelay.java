package com.liumapp.jspbasic.socket.socketDemo.util;

import com.liumapp.jspbasic.socket.socketDemo.entity.FileEntity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by liumapp on 7/6/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class CommandRelay implements Serializable{

    private String command;

    private boolean flag;

    private Object userObject = null;

    private Object fileObject = null;

    private byte[] bytes = null ;

    private ArrayList<FileEntity> fileList = null;

    public String getCommand() {
        return command;
    }

    public boolean isFlag() {
        return flag;
    }

    public Object getUserObject() {
        return userObject;
    }

    public Object getFileObject() {
        return fileObject;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public ArrayList<FileEntity> getFileList() {
        return fileList;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setUserObject(Object userObject) {
        this.userObject = userObject;
    }

    public void setFileObject(Object fileObject) {
        this.fileObject = fileObject;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public void setFileList(ArrayList<FileEntity> fileList) {
        this.fileList = fileList;
    }
}
