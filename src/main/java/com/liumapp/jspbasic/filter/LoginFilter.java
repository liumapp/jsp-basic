package com.liumapp.jspbasic.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by liumapp on 6/22/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class LoginFilter implements Filter {

    private FilterConfig config;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();

        //编码转换
        String charset = config.getInitParameter("charset");
        if (charset == null) {
            charset = "UTF-8";
        }
        request.setCharacterEncoding(config.getInitParameter(charset));

        String noCheckPaths = this.config.getInitParameter("noCheckPath");

        if (noCheckPaths != null) {
            String[] strArray = noCheckPaths.split(";");
            for (int i = 0 ; i < strArray.length ; i++) {

                if (strArray[i] == null || "".equals(strArray[i])) continue;

                if (request.getRequestURI().indexOf(strArray[i]) != -1) {
                    filterChain.doFilter(servletRequest , servletResponse);
                    return;
                }

            }
        }

        if (session.getAttribute("username") != null) {
            filterChain.doFilter(servletRequest , servletResponse);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    public void destroy() {

    }
}
