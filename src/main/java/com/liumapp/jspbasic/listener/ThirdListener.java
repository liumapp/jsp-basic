package com.liumapp.jspbasic.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by liumapp on 6/2/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class ThirdListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("third listener initialized");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("third listener destroyed");
    }
}
