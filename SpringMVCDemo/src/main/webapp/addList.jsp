<%--
  Created by IntelliJ IDEA.
  User: FXC
  Date: 2021/3/22
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/data/list" method="post">
        用户1编号：<input type="text" name="users[0].id">
        用户1姓名：<input type="text" name="users[0].name">
        用户2编号：<input type="text" name="users[1].id">
        用户2姓名：<input type="text" name="users[1].name">
        用户3编号：<input type="text" name="users[2].id">
        用户3姓名：<input type="text" name="users[2].name">
        <input type="submit" value="提交">
    </form>

</body>
</html>
