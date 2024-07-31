<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 7/30/2024
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang chủ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container p-3">
    <h1 class="m-2"> Danh sách Lớp</h1>
    <div style="display: flex; justify-content: space-between; align-items: center; margin: 20px 0;">
        <a href="/class-controller?action=add" class="btn btn-primary">Thêm mới lớp</a>
        <form action="/class-controller" method="post">
            <b>Tên sản phẩm: </b>
            <input type="text" name="className"/>
            <input type="submit" name="action" value="search"/>
        </form>
    </div>
    <table class="table table-striped">
        <thead>
        <tr style="text-align: center">
            <th scope="col">STT</th>
            <th scope="col">Tên Lớp</th>
            <th scope="col">Trạng thái</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items = "${classes}"  var ="c" >
            <tr style="text-align: center">
                <td>${c.classId}</td>
                <td>${c.className}</td>
                <td>${c.status ? "Hoạt động" : "Không hoạt động"}</td>
                <td><a href="/class-controller?action=detail&id=${c.classId}" class="btn btn-info ">Chi tiết</a></td>
                <td><a href="/class-controller?action=edit&id=${c.classId}" class="btn btn-warning ">Sửa</a></td>
                <td><a href="/class-controller?action=delete&id=${c.classId}" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xóa không')">Xóa</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>