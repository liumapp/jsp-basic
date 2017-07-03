package com.liumapp.jspbasic.socket;

import junit.framework.TestCase;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by liumapp on 7/3/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class UrlDemoTest extends TestCase{

    public void testChildUrl () {
        try {
            UrlDemo.childUrl();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void testReadStream () {
        try {
            UrlDemo.readStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
