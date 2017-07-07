package com.liumapp.jspbasic.socket.socketDemo.entity;

import java.io.Serializable;

/**
 * Created by liumapp on 7/6/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class FileEntity implements Serializable{

    private String userName;

    private int id;

    private String fileName;

    private byte[] fileContent;

    public FileEntity(int id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public FileEntity () {

    }

    public String getUserName() {
        return userName;
    }

    public int getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                '}';
    }



}
