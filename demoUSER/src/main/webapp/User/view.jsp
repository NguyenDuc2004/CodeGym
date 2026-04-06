<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin người dùng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-header bg-primary text-white">
                    <h4 class="mb-0">Chi tiết người dùng ${user.name}</h4>
                </div>
                <div class="card-body">
                    <table class="table">
                        <tr>
                            <th width="30%">Họ tên:</th>
                            <td>${user.name}</td>
                        </tr>
                        <tr>
                            <th>Email:</th>
                            <td>${user.email}</td>
                        </tr>
                        <tr>
                            <th>Quốc gia:</th>
                            <td>${user.country}</td>
                        </tr>
                    </table>
                </div>
                <div class="card-footer d-flex justify-content-between">
                    <a href="user" class="btn btn-secondary">
                        <i class="bi bi-arrow-left"></i> Quay lại danh sách
                    </a>
                    <a href="user?action=edit&id=${user.id}" class="btn btn-warning">
                        Chỉnh sửa
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>