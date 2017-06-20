package com.liumapp.jspbasic.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by liumapp on 6/7/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class SecondFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Start SecondFilter");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("do SecondFilter");
        filterChain.doFilter(servletRequest , servletResponse);
        System.out.println("SecondFilter end");
    }

    public void destroy() {
        System.out.println("destroy SecondFilter");
    }
}
