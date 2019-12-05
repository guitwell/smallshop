<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/6
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <c:forEach items="${allCategorys}" var="allCategorys">
        ID:${allCategorys.id}
        种类名:${allCategorys.name}<br/>
        级别:${allCategorys.leval}<br>
    </c:forEach>
</center>
<center>
    添加一级类别
    <form action="${pageContext.request.contextPath}/Category/addCategory" method="post">
        <input type="text" name="name"/>
        <input type="submit" value="提交"/>
    </form>
</center>
<hr/>
<center>
    添加二级类别
    <form action="${pageContext.request.contextPath}/Category/addCategory" method="post">
        <select name="parentid">
            <c:forEach items="${allParentCate}" var="allParentCate">
                <option value="${allParentCate.id}">${allParentCate.name}</option>
            </c:forEach>
        </select>
        </select>
        <input value="2" name="leval" type="hidden">
        <input type="text" name="name"/>
        <input type="submit" value="提交"/>
    </form>
</center>
</body>
</html>
