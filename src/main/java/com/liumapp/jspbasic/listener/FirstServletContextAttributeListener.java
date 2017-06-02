package com.liumapp.jspbasic.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Created by liumapp on 6/2/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class FirstServletContextAttributeListener implements ServletContextAttributeListener {
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("servletContextAttribute added , name is : " + servletContextAttributeEvent.getName());
    }

    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("servletContextAttribute removed , name is : " + servletContextAttributeEvent.getName());
    }

    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("servletContextAttribute replaced , name is : " + servletContextAttributeEvent.getName());
    }
}
