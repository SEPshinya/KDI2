<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Pagetest" method="get">
<h1><%= request.getAttribute("nowPage")%></h1>
<ul>
 <li><a href="http://localhost:8080/harashinya/Pagetest?page=1">＜＜</a></li>
 <li><a href="http://localhost:8080/harashinya/Pagetest?page=<%= request.getAttribute("prev")%>">＜</a></li>
 <li><a href="http://localhost:8080/harashinya/Pagetest?page=<%= request.getAttribute("page1")%>"><%= request.getAttribute("page1")%></a><br></li>
 <li><a href="http://localhost:8080/harashinya/Pagetest?page=<%= request.getAttribute("page2")%>"><%= request.getAttribute("page2")%></a><br></li>
 <li><a href="http://localhost:8080/harashinya/Pagetest?page=<%= request.getAttribute("page3")%>"><%= request.getAttribute("page3")%></a><br></li>
 <li><a href="http://localhost:8080/harashinya/Pagetest?page=<%= request.getAttribute("page4")%>"><%= request.getAttribute("page4")%></a><br></li>
 <li><a href="http://localhost:8080/harashinya/Pagetest?page=<%= request.getAttribute("page5")%>"><%= request.getAttribute("page5")%></a><br></li>
 <li><a href="http://localhost:8080/harashinya/Pagetest?page=<%= request.getAttribute("next")%>">＞</a><br></li>
 <li><a href="http://localhost:8080/harashinya/Pagetest?page=<%= request.getAttribute("Max")%>">＞＞</a></li>


</ul>
</form>
</body>
</html>