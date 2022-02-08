<%--
  Date: 2022/2/8
  Time: 16:27
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online</title>
</head>
<body>
<h1>当前有<span><%=this.getServletConfig().getServletContext().getAttribute("onlineCount")%></span>人在线</h1>
</body>
</html>
