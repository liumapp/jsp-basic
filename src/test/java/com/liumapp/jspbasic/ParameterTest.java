package com.liumapp.jspbasic;

import com.liumapp.jspbasic.util.Calculate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.TestCase;

/**
 * Created by liumapp on 6/26/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@RunWith(Parameterized.class)
public class ParameterTest {
    int expected = 0;
    int input1 = 0;
    int input2 = 0;

    public ParameterTest( int expected , int input1 , int input2) {
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> t() {
        return Arrays.asList(new Object[][]{
                {3,1,2},
                {4,2,2}
        });
    }

    @Test
    public void testAdd()
    {
        System.out.println("test add begin: while expected is " + expected);
        TestCase.assertEquals(expected , new Calculate().add(input1 ,input2));
    }

}
