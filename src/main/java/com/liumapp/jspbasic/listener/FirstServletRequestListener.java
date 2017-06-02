package com.liumapp.jspbasic.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Created by liumapp on 6/2/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class FirstServletRequestListener implements ServletRequestListener {
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("requestDestroyed");
    }

    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        String name = servletRequestEvent.getServletRequest().getParameter("name"); // by get method
        System.out.println("requestInitialized and name is :" + name);
    }
}
