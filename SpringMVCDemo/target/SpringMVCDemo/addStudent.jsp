<%--
  Created by IntelliJ IDEA.
  User: FXC
  Date: 2021/3/23
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addStudent</title>
</head>
<body>

    <form action="/converter/student" method="post">
        请输入学生信息：<input type="text" name="student"><br>(id-name-age)
        <input type="submit" value="提交">
    </form>

</body>
</html>
