<%--
  Created by IntelliJ IDEA.
  User: Nguyễn Khắc Minh Đức
  Date: 4/3/2026
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<
<html>
<head>
    <title>User List</title>
</head>
<body>
 <h1>List User</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <th>${user.id}</th>
            <th>${user.name}</th>
            <th>${user.email}</th>
            <th>${user.country}</th>
        </tr>
    </c:forEach>

</table>
</body>
</html>
