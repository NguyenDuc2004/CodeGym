<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi tiết sản phẩm | ${p.name}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">

    <style>
        body { background-color: #f0f2f5; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; }
        .detail-card {
            background: #fff;
            border-radius: 30px;
            border: none;
            overflow: hidden;
            box-shadow: 0 15px 35px rgba(0,0,0,0.1);
            margin-top: 50px;
        }
        .product-img-container {
            padding: 20px;
            background: #fff;
        }
        .product-img {
            width: 100%;
            border-radius: 20px;
            object-fit: cover;
            max-height: 500px;
            box-shadow: 0 10px 20px rgba(0,0,0,0.05);
        }
        .info-section {
            padding: 40px;
            background: #ffffff;
        }
        .price-text {
            font-size: 2.5rem;
            font-weight: 800;
            color: #ff4757;
        }
        .spec-box {
            background: #f8f9fa;
            border-radius: 15px;
            padding: 15px;
            text-align: center;
            border: 1px solid #eee;
        }
        .btn-back {
            border-radius: 12px;
            padding: 10px 25px;
            transition: 0.3s;
        }
    </style>
</head>
<body>

<div class="container pb-5">
    <div class="pt-4">
        <a href="product" class="btn btn-light btn-back shadow-sm">
            <i class="bi bi-arrow-left me-2"></i> Quay lại danh sách
        </a>
    </div>

    <div class="card detail-card shadow">
        <div class="row g-0">
            <div class="col-lg-6 product-img-container d-flex align-items-center justify-content-center bg-light">
                <img src="${p.image}" alt="${p.name}" class="product-img">
            </div>

            <div class="col-lg-6 info-section">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb mb-2">
                        <li class="breadcrumb-item"><a href="product">Sản phẩm</a></li>
                        <li class="breadcrumb-item active">${p.name}</li>
                    </ol>
                </nav>

                <h1 class="fw-bold text-dark mb-3">${p.name}</h1>

                <div class="mb-4">
                    <c:choose>
                        <c:when test="${p.status}">
                            <span class="badge bg-success-subtle text-success px-3 py-2 rounded-pill">
                                <i class="bi bi-check-circle-fill me-1"></i> Đang kinh doanh
                            </span>
                        </c:when>
                        <c:otherwise>
                            <span class="badge bg-danger-subtle text-danger px-3 py-2 rounded-pill">
                                <i class="bi bi-pause-circle-fill me-1"></i> Tạm dừng kinh doanh
                            </span>
                        </c:otherwise>
                    </c:choose>
                </div>

                <div class="price-text mb-4">
                    ${p.price} <small class="fs-4 fw-normal text-muted">VNĐ</small>
                </div>

                <div class="row g-3 mb-4">
                    <div class="col-sm-6">
                        <div class="spec-box">
                            <i class="bi bi-box-seam text-primary fs-3 d-block mb-2"></i>
                            <span class="text-muted small">Tồn kho hiện tại</span>
                            <h5 class="fw-bold mb-0">${p.stock} cái</h5>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="spec-box">
                            <i class="bi bi-shield-check text-primary fs-3 d-block mb-2"></i>
                            <span class="text-muted small">Bảo hành</span>
                            <h5 class="fw-bold mb-0">12 Tháng</h5>
                        </div>
                    </div>
                </div>

                <div class="description-content mb-5">
                    <h5 class="fw-bold text-dark border-start border-4 border-primary ps-3 mb-3">Mô tả sản phẩm</h5>
                    <p class="text-secondary lh-lg">
                        ${not empty p.description ? p.description : "Sản phẩm hiện đang được cập nhật mô tả chi tiết từ nhà cung cấp. Vui lòng quay lại sau."}
                    </p>
                </div>

                <div class="d-grid gap-2 d-md-flex">
                    <a href="product?action=edit&id=${p.id}" class="btn btn-warning btn-lg px-5 rounded-3 fw-bold shadow-sm">
                        <i class="bi bi-pencil-square me-2"></i> Chỉnh sửa
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>