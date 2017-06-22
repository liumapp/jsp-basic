<%--
  Created by IntelliJ IDEA.
  User: liumapp
  E-mail:liumapp.com@gmail.com
  Home-Page:http://www.liumapp.com
  Date: 6/22/17
  Time: 10:54 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<form action="<%= request.getContextPath()%>/servlet/LoginServlet" method="post">
    用户名:<input type="text" name="username">
    密码：<input type="password" name="password">
    <input type="submit" value="提交">
</form>
</body>
</html>
