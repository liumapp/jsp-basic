package com.liumapp.jspbasic.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by liumapp on 6/1/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class FirstListener  implements ServletContextListener{

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String author = servletContextEvent.getServletContext().getInitParameter("Author");
        servletContextEvent.getServletContext().setAttribute("homePage" , "http://www.liumapp.com");
        System.out.println("first listener initialized created by " + author + " and homepage is : " + servletContextEvent.getServletContext().getAttribute("homePage"));
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("first listener destroyed");
    }

}

