<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Detail Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body {
            color: #566787;
            background: #f5f5f5;
            font-family: 'Varela Round', sans-serif;
            font-size: 13px;
        }
    </style>
</head>
<body>
<div class="container-xl">
    <div class="col-10 offset-1">
        <div class="border " style="padding: 20px 20px 50px 20px; background-color: #fff;margin-top: 20px">
            <form:form action="/san-pham-chi-tiet/save" method="post" modelAttribute="detailProduct">
                <h4 class="text-center text-danger mb-3">Add Detail Product</h4>
                <div class="modal-body">
                    <div class="form-group row  mb-3">
                        <div class="col-6">
                            <label>Product</label>
                            <form:select path="sanPham" cssClass="form-select">
                                <c:forEach items="${listProducts}" var="sp">
                                    <form:option value="${sp.id}">${sp.name}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="col-6">
                            <label>Category</label>
                            <form:select path="loaiSanPham" cssClass="form-select">
                                <c:forEach items="${listCategories}" var="lsp">
                                    <form:option value="${lsp.id}">${lsp.name}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group row  mb-3">
                        <div class="col-6">
                            <label>Color</label>
                            <form:select path="mauSac" cssClass="form-select">
                                <c:forEach items="${listColors}" var="ms">
                                    <form:option value="${ms.id}">${ms.name}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="col-6">
                            <label>Position</label>
                            <form:select path="thuongHieu" cssClass="form-select">
                                <c:forEach items="${listPositions}" var="th">
                                    <form:option value="${th.id}">${th.name}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group row  mb-3">
                        <div class="col-6">
                            <label>Warranty year</label>
                            <form:input path="warrantyYear" cssClass="form-control"/>
                            <form:errors path="warrantyYear" cssStyle="color: red"/>
                        </div>
                        <div class="col-6">
                            <label>Quantity</label>
                            <form:input path="quantity" cssClass="form-control"/>
                            <form:errors path="quantity" cssStyle="color: red"/>
                        </div>
                    </div>
                    <div class="form-group row mb-3">
                        <div class="col-6">
                            <label>Price</label>
                            <form:input path="price" cssClass="form-control"/>
                            <form:errors path="price" cssStyle="color: red"/>
                        </div>
                        <div class="col-6">
                            <label>Describe</label>
                            <form:textarea path="describe" cssClass="form-control"/>
                            <form:errors path="describe" cssStyle="color: red"/>
                        </div>
                    </div>
                    <div class="form-group  mb-3 float-end">
                        <div class="col-5">
                            <button onclick="return confirm('Are you sure!')" class="btn btn-success">Add</button>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>