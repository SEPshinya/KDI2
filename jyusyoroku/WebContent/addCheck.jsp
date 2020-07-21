<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="addcheck.css">
<title></title>
</head>
<body>
<p>住所録管理システム：住所録登録</p>
<form action="AddCommitBL" method="post">
<div align=center class="content">
<ul style="list-style-type: none">
<li>名前*　　　　：<%= request.getParameter("name") %></li>
<li>住所*　　　　：<%= request.getParameter("address") %></li>
<li>電話番号　　 ：<%= request.getParameter("tell") %></li>
</ul>
</div>

<div align=center>
<input class="submit" type="submit" value="登録"style="width:200px;height:25px">
<input class="submit" type="reset" value="戻る"style="width:200px;height:25px">
</div>

<input type="hidden" name="name" value="<%= request.getParameter("name") %>">
<input type="hidden" name="address" value="<%= request.getParameter("address") %>">
<input type="hidden" name="tell" value="<%= request.getParameter("tell") %>">
<input type="hidden" name="categoryid" value="<%= request.getParameter("categoryid") %>">
</form>
</body>
</html>