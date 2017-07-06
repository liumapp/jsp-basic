package com.liumapp.jspbasic.io;

import com.liumapp.jspbasic.entity.Student;

import java.io.*;

/**
 * Created by liumapp on 7/6/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class ObjectSerializable {

    public static void main (String[] args) throws IOException, ClassNotFoundException {

        String file = "demo/obj.dat";

        /**
         * 对象的序列化
         */
        ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream(file)
        );

        Student stu = new Student("10001" , "liumapp" , 24);
        oos.writeObject(stu);
        oos.flush();
        oos.close();

        /**
         * 对象的反序列化
         */
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file)
        );
        Student stu2 = (Student)ois.readObject();
        System.out.println(stu2);
        ois.close();


    }

}
