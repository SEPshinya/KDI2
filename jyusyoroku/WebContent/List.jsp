<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<%@ page import= "java.util.ArrayList"%>
<%@ page import= "java.util.List"%>
<%@ page import= "java.sql.ResultSet"%>

<%ResultSet rs=(ResultSet)request.getAttribute("rs"); %>
<%! int listCnt=0; %>
<%! String nowPage=null; %>
<%! int maxPage=0; %>
<%! 	int id=0; //ID
		String name=null;  //名前
		String address=null; //住所
		String tel=null;    //電話番号
		String categoryid=null; //カテゴリー
%>
<%
%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>住所録一覧</title>
</head>
<body>
<form action="ListBL" method="get">
<input type="button" onclick="location.href='./add.jsp'" value="新規登録">
<ul>
<li><input type="text" name="SerchName"></li>
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
<td>


</td>
</tr>
</table>

</form>
</body>
</html>