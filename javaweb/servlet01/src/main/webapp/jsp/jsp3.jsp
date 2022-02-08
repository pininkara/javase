<%--
  Date: 2022/2/8
  Time: 13:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Tag</title>
</head>
<body>

<jsp:forward page="jsp4.jsp">
    <jsp:param name="name" value="nnk"/>
    <jsp:param name="age" value="14"/>
</jsp:forward>

</body>
</html>
