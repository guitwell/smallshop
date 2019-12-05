<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/6
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<table>
    <tr>
        <td>编号</td>
        <td>名字</td>
        <td>价格</td>
        <td>数量</td>
        <td>图片</td>
        <td>类别</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${allShops}" var="allShops">
        <tr>
            <td>${allShops.id}</td>
            <td>${allShops.name}</td>
            <td>${allShops.price}</td>
            <td>${allShops.count}</td>
            <td><img src="${pageContext.request.contextPath}/imgs/${allShops.picture}" width="30px" height="50px"/></td>
            <td>${allShops.category.name}</td>
            <td><a href="">删除</a><a href="${pageContext.request.contextPath}/Shops/findOneById?id=${allShops.id}">修改</a></td>
        </tr>
    </c:forEach>
</table>
    <a href="${pageContext.request.contextPath}/Category/findAll" >添加种类</a>
    <a href="${pageContext.request.contextPath}/Shops/findAllCates" >添加商品</a>
</center>
</body>
</html>
