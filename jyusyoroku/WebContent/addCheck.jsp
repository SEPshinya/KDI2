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
<p>住所録管理システム：住所録登録</p>
<form action="AddCommitBL" method="post">

<ul style="list-style-type: none">
<li>名前*　　　　：<%= request.getParameter("name") %></li>
<li>住所*　　　　：<%= request.getParameter("address") %></li>
<li>電話番号　　：<%= request.getParameter("tell") %></li>
</ul>

<input type="hidden" name="name" value="<%= request.getParameter("name") %>">
<input type="hidden" name="address" value="<%= request.getParameter("address") %>">
<input type="hidden" name="tell" value="<%= request.getParameter("tell") %>">
<input type="hidden" name="categoryid" value="<%= request.getParameter("categoryid") %>">

<input type="submit" value="登録">
<input type="reset" value="戻る">

</form>
</body>
</html>