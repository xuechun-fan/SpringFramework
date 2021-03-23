<%--
  Created by IntelliJ IDEA.
  User: FXC
  Date: 2021/3/23
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>SingleFileUpload</title>
</head>
<body>

    <form action="/file/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="img">
        <input type="submit" name="上传">
    </form>
    <img src="${path}">
</body>
</html>
