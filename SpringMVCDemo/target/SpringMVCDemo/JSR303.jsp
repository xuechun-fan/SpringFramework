<%--
  Created by IntelliJ IDEA.
  User: FXC
  Date: 2021/3/23
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>JSR303</title>
</head>
<body>
    <form:form modelAttribute="person" action="/validator/register" method="post">
        姓名：<form:input path="username"/><form:errors path="username"/><br>
        密码：<form:password path="password"/><form:errors path="password"/><br>
        邮箱：<form:input path="email"/><form:errors path="email"/><br>
        手机：<form:input path="phone"/><form:errors path="phone"/><br>
        <input type="submit" value="登录">
    </form:form>

</body>
</html>
