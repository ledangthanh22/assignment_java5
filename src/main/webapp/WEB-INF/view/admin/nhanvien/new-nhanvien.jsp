<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Staff</title>
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
            <form:form action="/nhan-vien/save" method="post" modelAttribute="staff">
                <h4 class="text-center text-danger mb-3">Add Staff</h4>
                <div class="modal-body">
                    <div class="form-group row  mb-3">
                        <div class="col-6">
                            <label >Code</label>
                            <form:input path="code" cssClass="form-control"/>
                            <form:errors path="code" cssStyle="color: red"/>
                        </div>
                        <div class="col-6">
                            <label>Name</label>
                            <form:input path="name" cssClass="form-control"/>
                            <form:errors path="name" cssStyle="color: red"/>
                        </div>
                    </div>
                    <div class="form-group row mb-3">
                        <div class="col-6">
                            <label>Gender</label> <br>
                            <div class="form-check form-check-inline">
                                <form:radiobutton path="gender" cssClass="form-check-input" value="true" checked="true" label="male"/>
                            </div>
                            <div class="form-check form-check-inline">
                                <form:radiobutton path="gender" cssClass="form-check-input" value="false" label="female"/>
                            </div>
                        </div>
                        <div class="col-6">
                            <label>Birthday</label>
                            <form:input path="birthday"  cssClass="form-control" type="date"/>
                            <form:errors path="birthday" cssStyle="color: red"/>
                        </div>
                    </div>
                    <div class="form-group row  mb-3">
                        <div class="col-6">
                            <label>Number phone</label>
                            <form:input path="numberPhone" cssClass="form-control"/>
                            <form:errors path="numberPhone" cssStyle="color: red"/>
                        </div>
                        <div class="col-6">
                            <label>Address</label>
                            <form:input path="address" cssClass="form-control"/>
                            <form:errors path="address" cssStyle="color: red"/>
                        </div>
                    </div>
                    <div class="form-group row mb-3">
                        <div class="col-6">
                            <label>Email</label>
                            <form:input path="email" cssClass="form-control"/>
                            <form:errors path="email" cssStyle="color: red"/>
                        </div>
                        <div class="col-6">
                            <label>Status</label> <br>
                            <div class="form-check form-check-inline">
                                <form:radiobutton path="status" cssClass="form-check-input" checked="true" value="0" label="doing"/>
                            </div>
                            <div class="form-check form-check-inline">
                                <form:radiobutton path="status" cssClass="form-check-input" value="1" label="took a break"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row mb-3">
                        <div class="col-6">
                            <label>City</label>
                            <form:select path="cuaHang" cssClass="form-select">
                                <c:forEach items="${listShops}" var="ch">
                                    <form:option value="${ch.id}">${ch.name}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="col-6">
                            <label>Nation</label>
                            <form:select path="chucVu" cssClass="form-select">
                                <c:forEach items="${listPositions}" var="cv">
                                    <form:option value="${cv.id}">${cv.name}</form:option>
                                </c:forEach>
                            </form:select>
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