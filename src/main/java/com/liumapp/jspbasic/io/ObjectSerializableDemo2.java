package com.liumapp.jspbasic.io;

/**
 * Created by liumapp on 7/6/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */

import java.io.*;


public class ObjectSerializableDemo2 {

    public static void main (String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("demo/obj1.dat")
        );
        Foo2 foo2 = new Foo2();
        oos.writeObject(foo2);
        oos.flush();
        oos.close();

        /**
         * 反序列化是否递归调用父类的构造函数
         */
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("demo/obj1.dat")
        );
        Foo2 foo3 = (Foo2)ois.readObject();
        System.out.println(foo3);

        ois.close();

        /**
         * 序列化bar2
         */
        ObjectOutputStream oos2 = new ObjectOutputStream(
                new FileOutputStream("demo/obj2.dat")
        );
        Bar2 bar2 = new Bar2();
        oos2.writeObject(bar2);
        oos2.flush();
        oos2.close();

        /**
         * 反序列化bar2
         * 可以看到
         * Bar因为没有实现Serializable接口
         * 所以其构造函数在反序列化的时候被调用
         */
        ObjectInputStream ois2 = new ObjectInputStream(
                new FileInputStream("demo/obj2.dat")
        );
        Bar2 bar3 = (Bar2) ois2.readObject();
        System.out.println(bar3);

        ois2.close();

    }

}

/**
 *  一个类如果实现了序列化接口，那么其子类都可以进行序列化
 */
class Foo implements Serializable {
    public Foo () {
        System.out.println("foo ...");
    }
}

class Foo1 extends Foo {
    public Foo1 () {
        System.out.println("foo1 ...");
    }
}

class Foo2 extends Foo1 {
    public Foo2 () {
        System.out.println("foo2 ...");
    }
}

class Bar {
    public Bar () {
        System.out.println("bar");
    }
}

class Bar1 extends Bar  implements Serializable{
    public Bar1 () {
        System.out.println("bar1 ...");
    }
}

class Bar2 extends Bar1 {
    public Bar2 () {
        System.out.println("bar2 ...");
    }
}