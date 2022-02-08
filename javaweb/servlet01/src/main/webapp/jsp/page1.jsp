<%--
  Date: 2022/2/8
  Time: 11:56
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PageContextDemo1</title>
</head>
<body>

<%
  pageContext.setAttribute("name1","nnk1");
  request.setAttribute("name2","nnk2");
  session.setAttribute("name3","nnk3");
  application.setAttribute("name4","nnk4");
%>

<%
  String name1=(String)pageContext.findAttribute("name1");
  String name2=(String)pageContext.findAttribute("name2");
  String name3=(String)pageContext.findAttribute("name3");
  String name4=(String)pageContext.findAttribute("name4");
  String name5=(String)pageContext.findAttribute("name5");
%>

<h1>取出的值为</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3>${name5}</h3>

<h3><%= name5%></h3>

</body>
</html>
