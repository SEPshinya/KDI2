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
<form action="AddCommitBL">
<div align=center class="content">
<ul style="list-style-type: none">
<li>名前*　　　　：<%= request.getAttribute("name") %></li>
<li>住所*　　　　：<%= request.getAttribute("address") %></li>
<li>電話番号　　 ：<%= request.getAttribute("tell") %></li>
</ul>
</div>

<input type="hidden" name="name" value="<%= request.getAttribute("name") %>">
<input type="hidden" name="address" value="<%= request.getAttribute("address") %>">
<input type="hidden" name="tell" value="<%= request.getAttribute("tell") %>">
<input type="hidden" name="categoryid" value="<%= request.getAttribute("categoryid") %>">

<div align=center>
<input class="submit" type="submit" value="登録"style="width:200px;height:25px">
<input class="submit" type="reset" value="戻る"style="width:200px;height:25px">
</div>

</form>
</body>
</html>