package com.liumapp.jspbasic;

import com.liumapp.jspbasic.util.Calculate;
import junit.framework.TestCase;

/**
 * Created by liumapp on 6/26/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class JunitFlowTest extends TestCase {


    @Override
    protected void setUp() throws Exception {
        System.out.println("this is setUp");
    }

    @Override
    protected void tearDown() throws Exception {
        System.out.println("this is tearDown");
    }

    /**
     * Rigourous Test :-)
     */
    public void testAdd()
    {
        System.out.println("test add begin");
        assertEquals(6 , new Calculate().add(3 ,3));
    }

    public void testSubtract ()
    {
        System.out.println("test subtract begin");
        assertEquals(1 , new Calculate().subtract(2  , 1));
    }
}
