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
        System.out.println("Start FirstFilter");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("do FirstFilter");
        filterChain.doFilter(servletRequest , servletResponse);
        System.out.println("FirstFilter end");
    }

    public void destroy() {
        System.out.println("destroy FirstFilter");
    }
}
