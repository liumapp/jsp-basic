package com.liumapp.jspbasic.entity;

import java.io.Serializable;

/**
 * Created by liumapp on 7/6/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class Student implements Serializable{

    public Student() {

    }

    public Student(String stuno, String stuname, int stuage) {
        this.stuno = stuno;
        this.stuname = stuname;
        this.stuage = stuage;
    }

    private String stuno;

    private String stuname;

    private int stuage;

    public String getStuno() {
        return stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public int getStuage() {
        return stuage;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public void setStuage(int stuage) {
        this.stuage = stuage;
    }
}
