<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/6
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h2>登录</h2>
    <form action="${pageContext.request.contextPath}/User/login" method="post">
        用户名 <input type="text" name="username" value="hr">
        密码<input type="text" name="password" value="hr">
        <input type="submit" value="登录">
    </form>
</center>
</body>
</html>
