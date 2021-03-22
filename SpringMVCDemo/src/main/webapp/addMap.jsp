<%--
  Created by IntelliJ IDEA.
  User: FXC
  Date: 2021/3/22
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/data/map" method="post">
        用户1编号：<input type="text" name="userMap[a].id"><br>
        用户1姓名：<input type="text" name="userMap[a].name"><br>
        用户2编号：<input type="text" name="userMap[b].id"><br>
        用户2姓名：<input type="text" name="userMap[b].name"><br>
        用户3编号：<input type="text" name="userMap[c].id"><br>
        用户3姓名：<input type="text" name="userMap[c].name"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
