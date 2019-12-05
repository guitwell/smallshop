<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/6
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#changecate").change(function () {
                console.log($(this).val());
                $("#soncate").empty();
                $.post("${pageContext.request.contextPath}/Category/findAllSon",{parentid:$(this).val()},function (result) {
                    for(var i=0;i<result.length;i++){
                        var option = $("<option/>").val(result[i].id).text(result[i].name);
                        $("#soncate").append(option);
                    }
                });
            });
        });
    </script>
</head>
<body>
<center>
    <form action="${pageContext.request.contextPath}/Shops/updateOne" method="post" enctype="multipart/form-data">
        ID:<input type="text" name="id" value="${theidShop.id}" readonly/>
        商品名:<input type="text" name="name" value="${theidShop.name}" />
        价格:<input type="text" name="price" value="${theidShop.price}"/>
        数量:<input type="text" name="count" value="${theidShop.count}"/>
        图片:<img src="${pageContext.request.contextPath}/imgs/${theidShop.picture}" width="30px" height="50px"/>
            <input type="file" name="picture" />
        类别: 类别:<select name="parentcateid" id="changecate">
        <c:forEach items="${allParentCate}" var="allParentCate">
            <option value="${allParentCate.id}">${allParentCate.name}</option>
        </c:forEach>
    </select>
        <select name="categoryid" id="soncate">

        </select>
        <input type="submit" value="提交"/>
    </form>
</center>
</body>
</html>
