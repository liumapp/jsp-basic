package com.liumapp.jspbasic.socket;

import junit.framework.TestCase;

import java.net.UnknownHostException;


/**
 * Created by liumapp on 7/3/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class InetAddressDemoTest extends TestCase {
    public void testLocalHost () {
        try {
            InetAddressDemo.localHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
