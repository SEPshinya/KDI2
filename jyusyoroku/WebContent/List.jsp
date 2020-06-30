<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>住所録一覧</title>
</head>
<body>
<form action="ListBL" method="get">
<h1><%= request.getAttribute("nowPage")%></h1>
<input type="button" onclick="location.href='/add.jsp'" value="新規登録">
<ul>
<li><input type="text" name="Serchname"></li>
<li><input type="submit" value="検索"></li>
</ul>
<ul>
 <li><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">＜＜</a></li>
 <li><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("prev")%>">＜</a></li>
 <li><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("page1")%>"><%= request.getAttribute("page1")%></a><br></li>
 <li><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("page2")%>"><%= request.getAttribute("page2")%></a><br></li>
 <li><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("page3")%>"><%= request.getAttribute("page3")%></a><br></li>
 <li><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("page4")%>"><%= request.getAttribute("page4")%></a><br></li>
 <li><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("page5")%>"><%= request.getAttribute("page5")%></a><br></li>
 <li><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("next")%>">＞</a><br></li>
 <li><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("Max")%>">＞＞</a></li>
</ul>

<table>
<tr>
<td>No.</td>
<td>名前</td>
<td>住所</td>
<td>電話番号</td>
<td>カテゴリー</td>
<td></td>
<td></td>
</tr>
<tr>
<td><%= request.getAttribute("name0")%></td>
<td><%= request.getAttribute("name0")%></td>
<td><%= request.getAttribute("address0")%></td>
<td><%= request.getAttribute("tel0")%></td>
<td><%= request.getAttribute("categoryid0")%></td>
<td><input type="button" onclick="location.href='/Edit.jsp'" value="編集"></td>
<td><input type="button" onclick="location.href='/Delete.jsp'" value="削除"></td>
</tr>
<tr>
<td><%= request.getAttribute("name1")%></td>
<td><%= request.getAttribute("name1")%></td>
<td><%= request.getAttribute("address1")%></td>
<td><%= request.getAttribute("tel1")%></td>
<td><%= request.getAttribute("categoryid1")%></td>
<td><input type="button" onclick="location.href='/Edit.jsp'" value="編集"></td>
<td><input type="button" onclick="location.href='/Delete.jsp'" value="削除"></td>
</tr>
<tr>
<td><%= request.getAttribute("name2")%></td>
<td><%= request.getAttribute("name2")%></td>
<td><%= request.getAttribute("address2")%></td>
<td><%= request.getAttribute("tel2")%></td>
<td><%= request.getAttribute("categoryid2")%></td>
<td><input type="button" onclick="location.href='/Edit.jsp'" value="編集"></td>
<td><input type="button" onclick="location.href='/Delete.jsp'" value="削除"></td>
</tr>
<tr>
<td><%= request.getAttribute("name3")%></td>
<td><%= request.getAttribute("name3")%></td>
<td><%= request.getAttribute("address3")%></td>
<td><%= request.getAttribute("tel3")%></td>
<td><%= request.getAttribute("categoryid3")%></td>
<td><input type="button" onclick="location.href='/Edit.jsp'" value="編集"></td>
<td><input type="button" onclick="location.href='/Delete.jsp'" value="削除"></td>
</tr>
<tr>
<td><%= request.getAttribute("name4")%></td>
<td><%= request.getAttribute("name4")%></td>
<td><%= request.getAttribute("address4")%></td>
<td><%= request.getAttribute("tel4")%></td>
<td><%= request.getAttribute("categoryid4")%></td>
<td><input type="button" onclick="location.href='/Edit.jsp'" value="編集"></td>
<td><input type="button" onclick="location.href='/Delete.jsp'" value="削除"></td>
</tr>
<tr>
<td><%= request.getAttribute("name5")%></td>
<td><%= request.getAttribute("name5")%></td>
<td><%= request.getAttribute("address5")%></td>
<td><%= request.getAttribute("tel5")%></td>
<td><%= request.getAttribute("categoryid5")%></td>
<td><input type="button" onclick="location.href='/Edit.jsp'" value="編集"></td>
<td><input type="button" onclick="location.href='/Delete.jsp'" value="削除"></td>
</tr>
<tr>
<td><%= request.getAttribute("name6")%></td>
<td><%= request.getAttribute("name6")%></td>
<td><%= request.getAttribute("address6")%></td>
<td><%= request.getAttribute("tel6")%></td>
<td><%= request.getAttribute("categoryid6")%></td>
<td><input type="button" onclick="location.href='/Edit.jsp'" value="編集"></td>
<td><input type="button" onclick="location.href='/Delete.jsp'" value="削除"></td>
</tr>
<tr>
<td><%= request.getAttribute("name7")%></td>
<td><%= request.getAttribute("name7")%></td>
<td><%= request.getAttribute("address7")%></td>
<td><%= request.getAttribute("tel7")%></td>
<td><%= request.getAttribute("categoryid7")%></td>
<td><input type="button" onclick="location.href='/Edit.jsp'" value="編集"></td>
<td><input type="button" onclick="location.href='/Delete.jsp'" value="削除"></td>
</tr>
<tr>
<td><%= request.getAttribute("name8")%></td>
<td><%= request.getAttribute("name8")%></td>
<td><%= request.getAttribute("address8")%></td>
<td><%= request.getAttribute("tel8")%></td>
<td><%= request.getAttribute("categoryid8")%></td>
<td><input type="button" onclick="location.href='/Edit.jsp'" value="編集"></td>
<td><input type="button" onclick="location.href='/Delete.jsp'" value="削除"></td>
</tr>
<tr>
<td><%= request.getAttribute("name9")%></td>
<td><%= request.getAttribute("name9")%></td>
<td><%= request.getAttribute("address9")%></td>
<td><%= request.getAttribute("tel9")%></td>
<td><%= request.getAttribute("categoryid9")%></td>
<td><input type="button" onclick="location.href='/Edit.jsp'" value="編集"></td>
<td><input type="button" onclick="location.href='/Delete.jsp'" value="削除"></td>
</tr>



</table>
</form>
</body>
</html>
