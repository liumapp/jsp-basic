<%--
  Created by IntelliJ IDEA.
  User: liumapp
  E-mail:liumapp.com@gmail.com
  Home-Page:http://www.liumapp.com
  Date: 6/2/17
  Time: 2:31 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.removeAttribute("requestName");
    request.getSession().removeAttribute("sessionName");
    request.getServletContext().removeAttribute("contextName");

    //session unbind
    request.getSession().removeAttribute("currentUser");
%>
<html>
<head>
    <title>destroy param</title>
</head>
<body>
this is destroy page.
<button onclick="location.href='<%= request.getContextPath()%>/init.jsp'">init</button>
<button onclick="location.href='<%= request.getContextPath()%>/destroy.jsp'">destroy</button>
</body>
</html>
