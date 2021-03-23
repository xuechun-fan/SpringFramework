<%--
  Created by IntelliJ IDEA.
  User: FXC
  Date: 2021/3/23
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <form:form modelAttribute="account" action="/validator/login" method="post">
        姓名：<form:input path="name"/><form:errors path="name"/><br>
        密码：<form:password path="password"/><form:errors path="password"/><br>
        <input type="submit" value="登录">
    </form:form>
</body>
</html>
