<%--
  Created by IntelliJ IDEA.
  User: liumapp
  E-mail:liumapp.com@gmail.com
  Home-Page:http://www.liumapp.com
  Date: 6/2/17
  Time: 11:27 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("requestName" , "requestValue");
    request.getSession().setAttribute("sessionName" , "sessionValue");
    request.getServletContext().setAttribute("contextName" , "contextValue");

    //session bind
    request.getSession().setAttribute("currentUser" , new com.liumapp.jspbasic.entity.User());
%>
<html>
<head>
    <title>init Param</title>
</head>
<body>
这是初始化值的界面
<button onclick="location.href='<%= request.getContextPath()%>/init.jsp'">init</button>
<button onclick="location.href='<%= request.getContextPath()%>/destroy.jsp'">destroy</button>
</body>
</html>
