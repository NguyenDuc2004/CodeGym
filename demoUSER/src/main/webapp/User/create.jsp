<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <div class="card shadow p-4" style="max-width: 500px; margin: auto;">
        <h4 class="text-center mb-4">Thêm người dùng</h4>

        <form action="user?action=create" method="post">

            <!-- Name -->
            <div class="mb-3">
                <label class="form-label">Họ tên</label>
                <input type="text" name="name" class="form-control" placeholder="Nhập họ tên" required>
            </div>

            <!-- Email -->
            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" name="email" class="form-control" placeholder="Nhập email" required>
            </div>

            <!-- Country -->
            <div class="mb-4">
                <label class="form-label">Quốc gia</label>
                <input type="text" name="country" class="form-control" placeholder="Nhập quốc gia" required>
            </div>

            <!-- Buttons -->
            <div class="d-flex justify-content-between">
                <a href="user" class="btn btn-secondary">Quay lại</a>
                <button type="submit" class="btn btn-primary">
                    Thêm mới
                </button>
            </div>

        </form>
    </div>
</div>

</body>
</html>