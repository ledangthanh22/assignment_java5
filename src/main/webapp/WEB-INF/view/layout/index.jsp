<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
<main class="row">
    <aside class="col-2" style="background-color:#fff;height: 750px">
        <ul class="navbar-nav me-auto" style="margin-left: 30px;font-size: 14px">
            <li class="nav-item"><a class="nav-link " style="color: cornflowerblue" href="/san-pham/show"><i class="fa-solid fa-dragon" style="color: cornflowerblue;font-size: 40px"></i>ThanhLee</a></li>
            <li class="nav-item mt-2"><a class="nav-link " href="/san-pham/show"><i class="fa-solid fa-vest-patches"></i>Sản phẩm</a></li>
            <li class="nav-item"><a class="nav-link " href="/mau-sac/show"><i class="fa-sharp fa-solid fa-palette"></i>Màu sắc</a></li>
            <li class="nav-item"><a class="nav-link " href="/loai-san-pham/show"><i class="fa-solid fa-chart-column"></i>Loại sản phẩm</a></li>
            <li class="nav-item"><a class="nav-link " href="/thuong-hieu/show"><i class="fa-solid fa-otter"></i>Thương hiệu</a></li>
            <li class="nav-item"><a class="nav-link " href="/cua-hang/show"><i class="fa-solid fa-shop"></i>Cửa hàng</a></li>
            <li class="nav-item"><a class="nav-link " href="/chuc-vu/show"><i class="fa-solid fa-server"></i>Chức vụ</a></li>
            <li class="nav-item"><a class="nav-link " href="/nhan-vien/show"><i class="fa-solid fa-users-gear"></i>Nhân viên</a></li>
            <li class="nav-item"><a class="nav-link " href="/khach-hang/show"><i class="fa-solid fa-people-group"></i> Khách hàng</a></li>
            <li class="nav-item"><a class="nav-link " href="/san-pham-chi-tiet/show"><i class="fa-solid fa-person-booth"></i>Chi tiết sản phẩm</a></li>
        </ul>
    </aside>
    <article class="col-10">
        <div class="row" style="height: 50px;background-color: #ffffff" >
        </div>
        <jsp:include page="${view}"/>
    </article>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>

</body>
</html>