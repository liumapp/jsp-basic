package com.liumapp.jspbasic.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by liumapp on 6/21/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class ErrorFilter implements Filter  {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("发现用户访问了一个不存在的页面");
        filterChain.doFilter(servletRequest ,  servletResponse);
    }

    public void destroy() {

    }
}
