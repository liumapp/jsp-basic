package com.liumapp.jspbasic.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liumapp on 6/7/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class TestFilter implements Filter{


    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("this is testFilter begin");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //重定向----注意request跟forward的区别
//        response.sendRedirect(req.getContextPath() + "/testFilter.jsp");
        //转发
        req.getRequestDispatcher("testFilter.jsp").forward(servletRequest , servletResponse);

        System.out.println("this is testFilter end");

    }

    public void destroy() {

    }
}
