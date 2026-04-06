<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản lý sản phẩm - Admin</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">

    <style>
        body { background-color: #f8f9fa; font-family: 'Segoe UI', sans-serif; }
        .admin-container {
            background: #fff;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.05);
            margin-top: 50px;
            margin-bottom: 50px;
        }
        .table img {
            width: 50px; height: 50px;
            object-fit: cover; border-radius: 8px;
        }
        .table th { background-color: #f1f3f5; color: #495057; border: none; font-size: 0.9rem; }
        .table td { vertical-align: middle; border-color: #f1f3f5; }

        /* Nút hành động tròn trịa */
        .btn-action {
            width: 35px; height: 35px;
            display: inline-flex; align-items: center; justify-content: center;
            border-radius: 8px; transition: 0.2s;
        }

        /* Tùy chỉnh Modal */
        .modal-content { border-radius: 20px; border: none; box-shadow: 0 10px 30px rgba(0,0,0,0.1); }
        .form-control, .form-select { border-radius: 10px; padding: 10px; border: 1px solid #e0e0e0; }
        .view-img { border-radius: 15px; max-height: 250px; width: 100%; object-fit: cover; }
    </style>
</head>
<body>

<div class="container admin-container">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <div>
            <h2 class="fw-bold text-primary mb-0">HỆ THỐNG QUẢN TRỊ</h2>
            <p class="text-muted small mb-0">Danh sách sản phẩm hiện có</p>
        </div>
        <button type="button" class="btn btn-primary d-flex align-items-center gap-2 shadow-sm"
                data-bs-toggle="modal" data-bs-target="#addProductModal"
                style="border-radius: 12px; padding: 10px 20px;">
            <i class="bi bi-plus-lg"></i> Thêm sản phẩm
        </button>
    </div>

    <div class="table-responsive">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Ảnh</th>
                <th>Tên sản phẩm</th>
                <th>Giá</th>
                <th class="text-center">Kho</th>
                <th class="text-center">Trạng thái</th>
                <th class="text-end">Hành động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${product}" var="p">
                <tr>
                    <td><img src="${p.image}" alt="img"></td>
                    <td>
                        <div class="fw-bold text-dark">${p.name}</div>
                        <small class="text-muted text-truncate d-inline-block" style="max-width: 150px;">${p.description}</small>
                    </td>
                    <td class="text-danger fw-bold">${p.price} đ</td>
                    <td class="text-center">${p.stock}</td>
                    <td class="text-center">
                        <c:choose>
                            <c:when test="${p.status}">
                                <span class="badge rounded-pill bg-success-subtle text-success px-3">Hoạt động</span>
                            </c:when>
                            <c:otherwise>
                                <span class="badge rounded-pill bg-danger-subtle text-danger px-3">Tạm ngưng</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td class="text-end">
                        <div class="btn-group">
                            <a href="product?action=view&id=${p.id}" class="btn btn-outline-info btn-action me-1">
                                <i class="bi bi-eye"></i>
                            </a>
                            <a href="product?action=edit&id=${p.id}" class="btn btn-outline-warning btn-action me-1">
                                <i class="bi bi-pencil"></i>
                            </a>
                            <a href="product?action=delete&id=${p.id}" class="btn btn-outline-danger btn-action"
                               onclick="return confirm('Xóa sản phẩm này?')">
                                <i class="bi bi-trash"></i>
                            </a>
                        </div>


                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="modal fade" id="addProductModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-lg">
        <div class="modal-content">
            <form action="product?action=create" method="post">
                <div class="modal-header border-0 pt-4 px-4">
                    <h5 class="modal-title fw-bold text-primary">THÊM SẢN PHẨM MỚI</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body px-4">
                    <div class="row g-3">
                        <div class="col-md-6">
                            <label class="form-label fw-bold">Tên sản phẩm</label>
                            <input type="text" name="name" class="form-control" placeholder="Tên sản phẩm..." required>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label fw-bold">Giá (VNĐ)</label>
                            <input type="number" name="price" class="form-control" placeholder="Giá..." required>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label fw-bold">Số lượng</label>
                            <input type="number" name="stock" class="form-control" placeholder="Số lượng..." required>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label fw-bold">Trạng thái</label>
                            <select name="status" class="form-select">
                                <option value="true">Hoạt động</option>
                                <option value="false">Tạm ngưng</option>
                            </select>
                        </div>
                        <div class="col-12">
                            <label class="form-label fw-bold">Link ảnh</label>
                            <input type="text" name="image" class="form-control" placeholder="URL hình ảnh...">
                        </div>
                        <div class="col-12">
                            <label class="form-label fw-bold">Mô tả</label>
                            <textarea name="description" class="form-control" rows="3"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer border-0 pb-4 px-4">
                    <button type="button" class="btn btn-light px-4" data-bs-dismiss="modal">Hủy</button>
                    <button type="submit" class="btn btn-primary px-5 shadow-sm" style="border-radius: 10px;">Lưu lại</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>