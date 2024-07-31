<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 7/30/2024
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<div class="container p-3">
    <h1 style="text-align: center">Cập nhật sinh viên</h1>
    <form action="/student-controller" method="post">
        <th>Id</th>
        <td><input type="text" name="id" readonly value="${studentEdit.id}"></td>
        <label for="fullName">Tên sinh viên: </label>
        <input type="text" name="fullName" id="fullName" value="${studentEdit.fullName}" required>
        <label for="gender">Giới tính: </label>
        <input type="checkbox" name="gender" id="gender" ${studentEdit != null && studentEdit.gender ? 'checked' : ''}>
        <label for="birthday">Ngày sinh: </label>
        <input type="date" name="birthday" id="birthday" value="${studentEdit != null ? studentEdit.birthday : ''}" required>
        <label for="address">Địa chỉ: </label>
        <input type="text" name="address" id="address" value="${studentEdit != null ? studentEdit.address : ''}" required>
        <label for="classId">Tên lớp: </label>
        <select name="classId" id="classId">
            <option value="">------- Lựa chọn -------</option>
            <c:forEach items="${listClass}" var="d">
                <option value="${d.classId}">${d.className}</option>
            </c:forEach>
        </select>
        <button class="btn btn-primary" type="submit" value="edit" name="action">Sửa</button>
        <a class="btn btn-info" href="/student-controller">Quay lại</a>
     </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
