package com.liumapp.jspbasic.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liumapp on 6/22/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
        super();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username + " 来访");

        if ("admin" . equals(username) && "admin" . equals(password)) {

            //验证通过
            req.getSession().setAttribute("username" , username);

            resp.sendRedirect(req.getContextPath() + "/success.jsp");


        } else {

            //验证失败
            resp.sendRedirect(req.getContextPath() + "/fail.jsp");
        }

    }
}
