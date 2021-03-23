<%--
  Created by IntelliJ IDEA.
  User: FXC
  Date: 2021/3/23
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>多文件上传</title>
</head>
<body>

    <form action="/file/uploads" method="post" enctype="multipart/form-data">
        file1:<input type="file" name="imgs"><br>
        file2:<input type="file" name="imgs"><br>
        file3:<input type="file" name="imgs"><br>
        <input type="submit" value="上传">
    </form>

    <c:forEach items="${files}" var="file">
        <img src="${file}" width="300px">
    </c:forEach>

</body>
</html>
