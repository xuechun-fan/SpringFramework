<%--
  Created by IntelliJ IDEA.
  User: FXC
  Date: 2021/3/23
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>show</title>
</head>
<body>
    <h1>学生信息</h1>
    <form:form modelAttribute="student">
        学生ID：<form:input path="id"/><br>
        学生姓名：<form:input path="name"/><br>
        学生年龄：<form:input path="age"/><br>
        是否党员：<form:checkbox path="flag" value="flag"/>党员<br>
        <%-- 爱好：<form:checkbox path="hobby" value="打球"/>打球<br>--%>
        <%-- 爱好：<form:checkbox path="hobby" value="玩游戏"/>玩游戏<br>--%>
        <%-- 爱好：<form:checkbox path="hobby" value="听音乐"/>听音乐<br>--%>
        <%-- 爱好：<form:checkbox path="hobby" value="睡觉"/>睡觉<br>--%>
        <%-- 爱好：<form:checkbox path="hobby" value="看电影"/>看电影<br>--%>
        爱好：<form:checkboxes path="selectHobby" items="${student.hobby}"/><br>
        RadioId:<form:radiobutton path="radioId" value="29"/><br>
        学生年级：<form:radiobuttons items="${student.gradeMap}" path="selectGrade"/><br>
        <%-- 城市:<form:select path="selectCity" items="${student.cityMap}"/><br>--%>
        <%-- 结合option标签使用 --%>
        所在城市：<form:select path="selectCity">
            <form:option value="1">杭州</form:option>
            <form:option value="2">郑州</form:option>
            <form:option value="3">广州</form:option>
            <form:option value="4">深圳</form:option>
        </form:select><br>

        自我介绍：
        <form:textarea path="introduce"/><br>

        <%-- 结合options标签使用 --%>
        <%--城市:
        &lt;%&ndash;<form:select path="selectCity">
            <form:options items="${student.cityMap}"/>
        </form:select><br>&ndash;%&gt;--%>


        
        <input type="submit" value="提交">
    </form:form>

</body>
</html>
