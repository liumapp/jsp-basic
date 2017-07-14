package com.liumapp.jspbasic.reflect.factory;

/**
 * Created by liumapp on 7/14/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */

interface fruit {
    public abstract void eat();
}

class Apple implements fruit {

    @Override
    public void eat() {
        System.out.println("eat apple");
    }
}

class Orange implements fruit {

    @Override
    public void eat() {
        System.out.println("eat orange");
    }
}



public class Factory {

    public static fruit getInstance(String className) {
        fruit f = null;

        try {
            f = (fruit) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return f;
    }

}
