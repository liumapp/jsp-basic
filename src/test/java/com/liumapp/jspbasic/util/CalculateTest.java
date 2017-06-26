package com.liumapp.jspbasic.util;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by liumapp on 6/26/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class CalculateTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CalculateTest( String testName )
    {
        super( testName );
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

    public void testDivide ()
    {
        System.out.println("test divide begin");
        assertEquals(1 , new Calculate().divide(1 ,1));
    }

    public void testMultiply ()
    {
        System.out.println("test multiply begin");
        assertEquals(1 , new Calculate().multiply(1,1));
    }

}
