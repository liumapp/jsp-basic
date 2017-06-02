package com.liumapp.jspbasic.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * Created by liumapp on 6/2/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class FirstServletRequestAttributeListener implements ServletRequestAttributeListener {
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("ServletRequestAttribute added , name is : " + servletRequestAttributeEvent.getName());
    }

    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("ServletRequestAttribute removed , name is : " + servletRequestAttributeEvent.getName());
    }

    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("ServletRequestAttribute replaced , name is : " + servletRequestAttributeEvent.getName());
    }
}
