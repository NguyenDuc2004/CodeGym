<%--
  Created by IntelliJ IDEA.
  User: Nguyễn Khắc Minh Đức
  Date: 4/4/2026
  Time: 3:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>List</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
</head>
<body>
<table class="table table-striped table-hover mt-3">
    <thead class="table-dark">
    <tr>
        <th>STT</th>
        <th>Họ tên</th>
        <th>Email</th>
        <th>Quốc gia</th>
        <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${listUser}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.country}"/></td>
            <td>
                <a href="user?action=view&id=${user.id}" class="btn btn-sm btn-primary">Xem</a>
                <a href="user?action=edit&id=${user.id}" class="btn btn-sm btn-warning">Sửa</a>
                <a href="user?action=delete&id=${user.id}" class="btn btn-sm btn-danger"
                   onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="d-flex justify-content-end ml-5">
    <a href="user?action=create" class="btn btn-primary" style="margin-right: 6px;">Thêm mới</a>
    <a href="/" class="btn btn-danger" style="margin-right: 6px;">Quay lại</a>
</div>


</body>
</html>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
