
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Quản lý khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">

    <style>
        *{
            padding:0;
            box-sizing: border-box;
            margin: 0;
        }
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            position: relative;
        }

        .header {
            background-color: #cfe2ff;
            background-image: url('/images/oto.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            height: 300px;
            padding: 30px 0;
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 20px;
        }

        .containers{
            width: 100%;
            height: 200px;
        }

        .footer {
            height: 70px;
            background-color: #cfe2ff;
            text-align: center;
            padding: 15px 0;
            position: absolute;
            bottom: 0;
            left: 0;
            right: 0;
        }
    </style>
</head>
<body>
<div class="header shadow-sm d-flex justify-content-center align-items-center gap-3">
    <i class="bi bi-person-video3 text-white" style="font-size: 2rem;"></i>
    <h2 class="fw-bold text-white m-0">Quản lý danh sách khách hàng</h2>
</div>

<!-- CONTENT -->
<div class="containers text-center d-flex flex-column justify-content-center align-items-center gap-3">
    <a href="${pageContext.request.contextPath}/user"
       class="btn btn-primary btn-lg px-3 d-flex align-items-center gap-2">
        Quản lý danh sách khách hàng
        <i class="bi bi-arrow-bar-right text-danger"></i>
    </a>

    <a href="${pageContext.request.contextPath}/product"
       class="btn btn-primary btn-lg px-3 d-flex align-items-center gap-2">
        Quản lý danh sách sản phẩm
        <i class="bi bi-arrow-bar-right text-danger"></i>
    </a>
</div>

<!-- FOOTER -->
<div class="footer">
    <small class="text-muted">Java Web - Servlet & JSP</small>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
```
