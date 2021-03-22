<%--
  Created by IntelliJ IDEA.
  User: FXC
  Date: 2021/3/22
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>  <!-- 设置解析EL表达式 -->
<html>
<head>
    <title>View</title>
</head>
<body>

    ${requestScope.user}
    <hr>
    ${sessionScope.user}

</body>
</html>
