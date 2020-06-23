<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ResultSet rs;
    int listCnt;
    String nowPage;
    int maxPage;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>住所録</title>
</head>
<body>
<form action="ListBL" method="Post">
<input type="button" onclick="location.href='/add.jsp'" value="新規登録">
<ul>
<li><input type="text" name="Serchname"></li>
<li><input type="submit" value="検索"></li>
</ul>
<ul>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
<li></li>
</ul>
</form>

</body>
</html>