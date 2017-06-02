package com.liumapp.jspbasic.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by liumapp on 6/2/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class FirstHttpSessionAttributeListener implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("HttpSessionAttribute added , name is : " + httpSessionBindingEvent.getName());
    }

    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("HttpSessionAttribute removed , name is : " + httpSessionBindingEvent.getName());
    }

    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("HttpSessionAttribute replaced , name is : " + httpSessionBindingEvent.getName());
    }
}
