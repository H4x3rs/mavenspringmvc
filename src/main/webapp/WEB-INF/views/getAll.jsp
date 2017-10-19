<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: A-ren
  Date: 2017/10/19
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserList</title>
</head>
<body>

<table>
    <tr>
        <td>id</td>
        <td>姓名</td>
        <td>电话</td>
        <td>邮箱</td>
        <td>密码</td>
        <td>创建时间</td>
    </tr>
    <c:forEach items="${userlist}" var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.nickname}"/></td>
            <td><c:out value="${user.phone}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.password}"/></td>
            <td><c:out value="${user.create_at}"/></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
