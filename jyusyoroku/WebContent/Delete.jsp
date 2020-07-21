<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="addcheck.css">
<title>削除</title>
</head>
<body>
<p>住所録管理システム：削除</p>
<form action="DeleteCommit" method="get">
<p>下記住所録を削除します。よろしいですか？</p>
<ul style="list-style-type: none">
<li>名前*　　　　：<%= request.getParameter("name") %></li>
<li>住所*　　　　：<%= request.getParameter("address") %></li>
<li>電話番号　 　：<%= request.getParameter("tell") %></li>
<li>カテゴリー　 　：<%= request.getParameter("id") %></li>
</ul>

<input type="hidden" name="name" value="<%= request.getParameter("name") %>">
<input type="hidden" name="address" value="<%= request.getParameter("address") %>">
<input type="hidden" name="tell" value="<%= request.getParameter("tell") %>">
<input type="hidden" name="categoryid" value="<%= request.getParameter("categoryid") %>">
<input type="hidden" name="delete_flg" value="<%= request.getParameter("delete_flg") %>">
<input type="hidden" name="id" value="<%= request.getParameter("id") %>">

<input type="submit" value="削除" >
<input type="reset" value="戻る">

</form>
</body>
</html>