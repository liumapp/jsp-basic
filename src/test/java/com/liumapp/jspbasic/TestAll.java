package com.liumapp.jspbasic;

import com.liumapp.jspbasic.util.CalculateTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by liumapp on 6/26/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class TestAll extends TestCase{

    public static Test suite()
    {
        TestSuite ts = new TestSuite();

        ts.addTestSuite(CalculateTest.class);
        ts.addTestSuite(JunitFlowTest.class);

        return ts;
    }

}
