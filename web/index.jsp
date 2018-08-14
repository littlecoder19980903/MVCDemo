<%--
  Created by IntelliJ IDEA.
  User: helloJava
  Date: 2018/8/13
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<center>
    <form action="./register" method="post">
        <input type="text" name="username" placeholder="请输入用户名"/>
        <input type="password" name="password" placeholder="请输入密码"/>
        <input type="submit" value="注册"/>
    </form>
</center>
<div style="color:red" align="center">${msg}</div>
</body>
</html>
