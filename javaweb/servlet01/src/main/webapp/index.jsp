<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<h1>Index</h1>
<h2>Hello World!</h2>

<form action="${pageContext.request.contextPath}/login" method="post">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    爱好：
    <input type="checkbox" name="hobby" value="mmr">mmr
    <input type="checkbox" name="hobby" value="code">code
    <input type="checkbox" name="hobby" value="sing">sing
    <input type="checkbox" name="hobby" value="movie">movie
    <br>
    <input type="submit">
</form>

</body>

</html>
