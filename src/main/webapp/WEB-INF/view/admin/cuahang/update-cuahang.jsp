<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Shop</title>
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
    <div class="col-8 offset-2">
        <div class="border" style="padding: 20px 20px 50px 20px; background-color: #fff;margin-top: 20px">
            <form:form action="/cua-hang/update" method="post" modelAttribute="shop">
                <h4 class="text-center text-danger mb-3">Update Shop</h4>
                <div class="modal-body">
                    <form:hidden path="id"/>
                    <div class="form-group  mb-3">
                        <label>Code</label>
                        <form:input path="code" cssClass="form-control"/>
                        <form:errors path="code" cssStyle="color: red"/>
                    </div>
                    <div class="form-group  mb-3">
                        <label>Name</label>
                        <form:input path="name" cssClass="form-control"/>
                        <form:errors path="name" cssStyle="color: red"/>
                    </div>
                    <div class="form-group  mb-3">
                        <label>Address</label>
                        <form:input path="address" cssClass="form-control"/>
                        <form:errors path="address" cssStyle="color: red"/>
                    </div>
                    <div class="form-group  mb-3">
                        <label>City</label>
                        <form:select path="city" cssClass="form-select">
                            <form:option value="Thai Nguyen">Thai Nguyen</form:option>
                            <form:option value="Ha Noi">Ha Noi</form:option>
                            <form:option value="Bac Ninh">Bac Ninh</form:option>
                            <form:option value="Thanh Hoa">Thanh Hoa</form:option>
                        </form:select>
                    </div>
                    <div class="form-group  mb-3">
                        <label>Nation</label>
                        <form:select path="nation" cssClass="form-select">
                            <form:option value="Viet Nam">Viet Nam</form:option>
                            <form:option value="Trung Quoc">Trung Quoc</form:option>
                            <form:option value="Lao">Lao</form:option>
                            <form:option value="Han Quoc">Han Quoc</form:option>
                        </form:select>
                    </div>
                    <div class="form-group  mb-3 float-end">
                        <div class="col-5">
                            <button onclick="return confirm('Are you sure!')" class="btn btn-success">Update</button>
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