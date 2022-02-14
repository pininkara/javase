<%--
  Date: 2022/2/14
  Time: 17:38
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/upload2" enctype="multipart/form-data" method="post">
  <input type="file" name="file">
  <input type="submit" value="upload">
</form>

</body>
</html>
