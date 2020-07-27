<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0">
<title></title>
<link rel="stylesheet" type="text/css" href="add.css">
</head>
<body>
<p>住所録管理システム：住所録登録</p>
<form action="AddBL" method="GET">
<div align=center>
<ul style="list-style-type: none">
<li>名前*　　 　：<input type="text" class="name" size="12" name="name"></li>
<li>住所*　　 　：<input type="text" class="address" name="address"></li>
<li>電話番号　　：<input type="text" class="tel"name="tell"></li>
<li class="selected">カテゴリ　　：<select name="categoryid"class="categoryid">
<option value="1">家族</option>
<option value="2">親戚</option>
<option value="3">知人</option>
<option value="4">仕事</option>
<option value="5">その他</option>
</select>
</li>
</ul>
</div>

<div class=submit align=center>
<input  type="submit" value="確認" style="width:200px;height:25px">
<input  type="reset" value="戻る" style="width:200px;height:25px">
</div>



</form>
</body>
</html>
