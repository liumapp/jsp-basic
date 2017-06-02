<%--
  Created by IntelliJ IDEA.
  User: liumapp
  E-mail:liumapp.com@gmail.com
  Home-Page:http://www.liumapp.com
  Date: 5/31/17
  Time: 7:38 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%= request.getSession().getAttribute("currentUser")%>

hello world

<button onclick="location.href='<%= request.getContextPath()%>/init.jsp'">init</button>
<button onclick="location.href='<%= request.getContextPath()%>/destroy.jsp'">destroy</button>
</body>
</html>
