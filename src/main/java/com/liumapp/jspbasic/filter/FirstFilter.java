package com.liumapp.jspbasic.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by liumapp on 6/6/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class FirstFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Start filter");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("do Filter");
        filterChain.doFilter(servletRequest , servletResponse);
        System.out.println("filter end");
    }

    public void destroy() {
        System.out.println("destroy Filter");
    }
}
