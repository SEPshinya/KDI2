<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="Edit.css">
<title>Insert title here</title>
</head>
<body>
<p>住所録管理システム：住所録編集</p>
<form action="EditBL" method="GET">


<div align=center>
 <ul style="list-style-type: none">
<li>名前*　　 　：<input type="text" class="name"name="name" value=<%= request.getParameter("name") %>></li>
<li>住所*　　 　：<input type="text" class="address"name="address" value=<%= request.getParameter("address") %>></li>
<li>電話番号　　：<input type="text" class="tel"name="tell" value=<%= request.getParameter("tel") %>></li>
<li class="selected">カテゴリ　　：<select name="categoryid" class="categryid">
<option value="1"></option>
<option value="2">親戚</option>
<option value="3">知人</option>
<option value="4">仕事</option>
<option value="5">その他</option>
</select>
</li>
</ul>
</div>
<div class=submit align=center>
<input type="hidden" name="id" value="<%= request.getParameter("id") %>">
<input type="submit" value="確認" style="width:200px;height:25px">
<input type="reset" value="戻る" style="width:200px;height:25px">
</div>
</form>
</body>
</html>
