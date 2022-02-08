<%--
  Date: 2022/2/8
  Time: 10:43
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=new java.util.Date()%>
<%
    int sum = 0;
    for (int i = 1; i <= 100; i++) {
        sum += i;
    }
    out.println("<h1>Sum=" + sum + "</h1>");
%>

<%!
static {
    System.out.println("Loading Servlet!");
}
%>

</body>
</html>
