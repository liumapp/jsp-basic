package com.liumapp.jspbasic.entity;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by liumapp on 7/6/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class Student implements Serializable{

    private String stuno;

    private String stuname;

    /**
     * transient修饰后，该属性不会进行jvm默认的序列化
     * 但可以自己完成序列化
     * 详情见下面的writeObject和readObject
     */
    private transient int stuage;

    public Student() {

    }

    public Student(String stuno, String stuname, int stuage) {
        this.stuno = stuno;
        this.stuname = stuname;
        this.stuage = stuage;
    }

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

    @Override
    public String toString() {
        return "Student{" +
                "stuno='" + stuno + '\'' +
                ", stuname='" + stuname + '\'' +
                ", stuage=" + stuage +
                '}';
    }

    private void writeObject(java.io.ObjectOutputStream s) throws IOException {
        /**
         * 把jvm能默认序列化的元素进行序列化操作
         */
        s.defaultWriteObject();

        /**
         * 自己完成stuage的序列化
         */
        s.writeInt(stuage);

    }

    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException {
        /**
         * 把jvm能默认反序列化的元素进行反序列化操作
         */
        s.defaultReadObject();

        /**
         * 自己完成stuage的反序列化操作
         */
        this.stuage = s.readInt();

    }
}
