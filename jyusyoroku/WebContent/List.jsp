<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<%@ page import= "java.util.ArrayList"%>
<%@ page import= "java.util.List"%>
<%@ page import= "java.sql.*"%>

<%  ResultSet rs=(ResultSet)request.getAttribute("rs");%>
<%! int listCnt=0;
	String nowPage=null;
	int maxPage=0;
	int id=0; //ID
	String name=null;  //名前
	String address=null; //住所
	String tel=null;    //電話番号
	String categoryid=null; //カテゴリー
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
<table>
<tr>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">＜＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("prev")%>">＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("page1")%>"><%= request.getAttribute("page1")%></a><br></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("page2")%>"><%= request.getAttribute("page2")%></a><br></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("page3")%>"><%= request.getAttribute("page3")%></a><br></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("page4")%>"><%= request.getAttribute("page4")%></a><br></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("page5")%>"><%= request.getAttribute("page5")%></a><br></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("next")%>">＞</a><br></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("Max")%>">＞＞</a></td>
</tr>
</table>

</form>
<table border="1">
<%
while(rs.next()){
%>
<form name=<%=rs.getInt("id") %> method="post" accept-charset="UTF-8">

	<tr>
	<td align="center"><%=rs.getInt("id") %></td>
	<td align="center"><%=rs.getString("name")%></td>
	<td align="center"><%=rs.getString("address") %></td>
	<td align="center"><%=rs.getString("tel") %></td>
	<td align="center"><%=rs.getString("categoryid") %></td>

	<input name="id" type="hidden" value=<%=rs.getInt("id") %>>
	<input name="name" type="hidden" value=<%=rs.getString("name") %>>
	<input name="tel" type="hidden" value=<%=rs.getString("tel") %>>
	<input name="address" type="hidden" value=<%=rs.getString("address") %>>
	<input name="categoryid" type="hidden" value=<%=rs.getString("categoryid") %>>


	<td align="center"><button type="submit" formaction="Edit.jsp">編集</button>
	<button type="submit" formaction="Delete.jsp">排除</button></td>
	</tr>
</form>

<%
	}
%>
</table>

<form action="ListBL">
<table>
<tr>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">＜＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("prev")%>">＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("page1")%>"><%= request.getAttribute("page1")%></a><br></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("page2")%>"><%= request.getAttribute("page2")%></a><br></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("page3")%>"><%= request.getAttribute("page3")%></a><br></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("page4")%>"><%= request.getAttribute("page4")%></a><br></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("page5")%>"><%= request.getAttribute("page5")%></a><br></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("next")%>">＞</a><br></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%= request.getAttribute("Max")%>">＞＞</a></td>
</tr>
</table>
<input type="button" onclick="location.href='./add.jsp'" value="新規登録">
</form>



</body>
</html>