<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
<li><a href=http://localhost:8080/jyusyoroku/List.jsp?1>＜＜</a></li>
<li><a href=http://localhost:8080/jyusyoroku/List.jsp?<%request.getParameter("tell"); %>></a></li>
<li><a href=http://localhost:8080/jyusyoroku/List.jsp?<%request.getParameter("tell"); %>></a></li>
<li><a href=http://localhost:8080/jyusyoroku/List.jsp?<%request.getParameter("tell"); %>>２</a></li>
<li><a href=http://localhost:8080/jyusyoroku/List.jsp?<%request.getParameter("tell"); %>>３</a></li>
<li><a href=http://localhost:8080/jyusyoroku/List.jsp?<%request.getParameter("tell"); %>>４</a></li>
<li><a href=http://localhost:8080/jyusyoroku/List.jsp?<%request.getParameter("tell"); %>>5</a></li>
<li><a href=http://localhost:8080/jyusyoroku/List.jsp?<%request.getParameter("tell"); %>>＞</a></li>
<li><a href=http://localhost:8080/jyusyoroku/List.jsp?<%request.getParameter("maxPage"); %>>＞＞</a></li>
</ul>
</form>

</body>
</html>