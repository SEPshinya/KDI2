<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<p>一覧仮説</p>
<form action="ListBL" method="GET">


 <ul style="list-style-type: none">
<li><%= request.getParameter("id") %></li>
<li><%= request.getParameter("name") %></li>
<li><%= request.getParameter("address") %></li>
<li><%= request.getParameter("tell") %></li>
<li><%= request.getParameter("dlete_flg") %></li>
</ul>

<input type="hidden" name="id" value="<%= request.getParameter("id") %>">
<input type="hidden" name="name" value="<%= request.getParameter("name") %>">
<input type="hidden" name="address" value="<%= request.getParameter("address") %>">
<input type="hidden" name="tell" value="<%= request.getParameter("tell") %>">
<input type="hidden" name="categoryid" value="<%= request.getParameter("categoryid") %>">
<input type="hidden" name="delete_flg" value="<%= request.getParameter("delete_flg") %>">







</form>
</body>
</html>