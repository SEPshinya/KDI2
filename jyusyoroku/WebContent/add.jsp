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
<p>住所録管理システム：住所録編集</p>
<form action="AddBL" method="GET">

 <ul style="list-style-type: none">
<li>名前*　　　　：<input type="text" name="name"></li>
<li>住所*　　　　：<input type="text" name="address"></li>
<li>電話番号　　：<input type="text" name="tell"></li>
<li>カテゴリ　　　 ：<select name="categoryid">
<option value="1">家族</option>
<option value="2">親戚</option>
<option value="3">知人</option>
<option value="4">仕事</option>
<option value="5">その他</option>
</select>
</li>
</ul>

<input type="submit" value="確認">
<input type="reset" value="戻る">



</form>
</body>
</html>
