<%--
  Created by IntelliJ IDEA.
  User: wangxianchao
  Date: 2021/2/11
  Time: 1:20 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生信息</title>
</head>
<body>
<form action="addStudentController" method="post">
    学号：<input type="text" name="id"><br/>
    姓名：<input type="text" name="name"><br/>
    性别：<input type="text" name="sex"><br/>
    生日：<input type="text" name="birthday"><br/>
    <input type="submit" value="添加">
</form>
</body>
</html>
