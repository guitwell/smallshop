<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#addreco").live('mouseover',function () {
                var name = $(this).parent().next().children("a:first-child").text();
                $.post("${pageContext.request.contextPath}/User/addRecom",{name:name},function (result) {

                });
            });

            setInterval(aa,5000);
            function aa(){
                $.post("${pageContext.request.contextPath}/User/flashRecommend",function (result) {
                    $("#theRomes").empty();
                    for (var i=0;i<result.length;i++){
                        $("#theRomes").append($("<img src='${pageContext.request.contextPath}/imgs/"+result[i].picture+"' width='30px' height='50px'/><a>"+result[i].name+"</a><br/>"));
                    }
                },'JSON');
            }

        });

    </script>

</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/User/findByName">
    <input type="text" name="name" value=""/>
    <input type="submit" value="查询"/>
</form>
    <table>
        <c:forEach items="${theshops}" var="theshops">
        <tr>
            <td><img id="addreco" src="${pageContext.request.contextPath}/imgs/${theshops.picture}" width="30px" height="50px"/></td>
            <td>
                <a href="" id="thename">${theshops.name}</a>
                价格<a href="">${theshops.price}</a>
            </td>
        </tr>
            <tr>
            </tr>
        </c:forEach>
    </table>
<hr>
<font id="theRomes">

</font>
</body>
</html>
