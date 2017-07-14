package com.liumapp.jspbasic.reflect.factory;

import junit.framework.TestCase;

/**
 * Created by liumapp on 7/14/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class FactoryTest extends TestCase {

    public void test () {
        fruit f = Factory.getInstance("com.liumapp.jspbasic.reflect.factory.Apple");
        f.eat();
    }

}
