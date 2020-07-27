<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<%@ page import= "java.util.ArrayList"%>
<%@ page import= "java.util.List"%>
<%@ page import= "java.sql.*"%>

<%  ResultSet rs=(ResultSet)request.getAttribute("rs");%>
<% String nowPage=(String)request.getAttribute("nowPage"); %>
<% //int maxPage=(int)request.getAttribute("maxPage");%>
<% int np=(int)request.getAttribute("np"); %>
<% int listCnt=(int)request.getAttribute("listCnt"); %>
<%!	int id=0; //ID
	String name=null;  //名前
	String address=null; //住所
	String tel=null;    //電話番号
	String categoryid=null; //カテゴリー
	int maxPage=0;
%>
<%maxPage=listCnt/10; %>

<%if(listCnt%10>0){
	maxPage=maxPage+1;
}%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>住所録一覧</title>
</head>
<body>
<form>
<input type="button" onclick="location.href='./add.jsp'" value="新規登録">
<ul style="list-style-type: none">
<li><input type="text" name="SerchName"></li>
<li><input type="submit" value="検索"></li>
</ul>
</form>
<table border="1">
<tr>
<td>No</td>
<td>名前</td>
<td>住所</td>
<td>電話番号</td>
<td>カテゴリー</td>
<td></td>
</tr>
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
<%}%>
</table>



<form>
<% if(maxPage==1||maxPage==0){ %>
<table>
<tr>
<td>＜＜</td>
<td>＜</td>
<td>1</td>
<td>＞</td>
<td>＞＞</td>
</tr>
</table>
<%} else if(maxPage==2&&np==1){%>
<table>
<tr>
<td>＜＜</td>
<td>＜</td>
<td>1</td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=2">2</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=2">＞</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=2">＞＞</a></td>
</tr>
</table>

<%} else if(maxPage==2&&np==2){%>
<table>
<tr>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">＜＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">1</a></td>
<td>2</td>
<td>＞</td>
<td>＞＞</td>
</tr>
</table>

<%} else if(maxPage==3&&np==1){%>
<table>
<tr>
<td>＜＜</td>
<td>＜</td>
<td>1</td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=2">2</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=3">3</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=2">＞</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=3">＞＞</a></td>
</tr>
</table>

<%} else if(maxPage==3&&np==2){%>
<table>
<tr>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">＜＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">1</a></td>
<td>2</td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=3">3</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=3">＞</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=3">＞＞</a></td>
</tr>
</table>

<%} else if(maxPage==3&&np==3){%>
<table>
<tr>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">＜＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=2">＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">1</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=2">2</a></td>
<td>3</td>
<td>＞</td>
<td>＞＞</td>
</tr>
</table>

<%} else if(maxPage==4&&np==1){%>
<table>
<tr>
<td>＜＜</td>
<td>＜</td>
<td>1</td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=2">2</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=3">3</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=4">4</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=2">＞</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=4">＞＞</a></td>
</tr>
</table>

<%} else if(maxPage==4&&np==2){%>
<table>
<tr>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">＜＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">1</a></td>
<td>2</td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=3">3</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=4">4</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=3">＞</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=4">＞＞</a></td>
</tr>
</table>

<%} else if(maxPage==4&&np==3){%>
<table>
<tr>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">＜＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=2">＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">1</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=2">2</a></td>
<td>3</td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=4">4</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=4">＞</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=4">＞＞</a></td>
</tr>
</table>
<%} else if(maxPage==4&&np==4){%>
<table>
<tr>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">＜＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=2">＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">1</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=2">2</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=3">3</a></td>
<td>4</td>
<td>＞</td>
<td>＞＞</td>
</tr>
</table>
<%}else if(maxPage>=5&&np==1){ %>
<table>
<tr>
<td>＜＜</td>
<td>＜</td>
<td>1</td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=2">2</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=3">3</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=4">4</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=5">5</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=2">＞</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=5">＞＞</a></td>
</tr>
</table>
<%}else if(maxPage>=5&&np==2){ %>
<table>
<tr>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">＜＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">1</a></td>
<td>2</td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=3">3</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=4">4</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=5">5</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=3">＞</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=5">＞＞</a></td>
</tr>
</table>

<%}else if(maxPage>=5&&np==3){ %>
<table>
<tr>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">＜＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=String.valueOf(np-1)%>">＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">1</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=2">2</a></td>
<td>3</td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=4">4</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=5">5</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=String.valueOf(np+1)%>">＞</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=maxPage%>">＞＞</a></td>
</tr>
</table>

<%}else if(maxPage==np){%>
<table>
<tr>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">＜＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=String.valueOf(np-1)%>">＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=String.valueOf(np-4)%>"><%=String.valueOf(np-4)%></a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=String.valueOf(np-3)%>"><%=String.valueOf(np-3)%></a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=String.valueOf(np-2)%>"><%=String.valueOf(np-2)%></a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=String.valueOf(np-1)%>"><%=String.valueOf(np-1)%></a></td>
<td><%=String.valueOf(maxPage)%></td>
<td>＞</td>
<td>＞＞</td>
</tr>
</table>

<%}else if(maxPage-1==np){ %>
<table>
<tr>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">＜＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=String.valueOf(np-1)%>">＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=String.valueOf(np-3)%>"><%=String.valueOf(np-3)%></a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=String.valueOf(np-2)%>"><%=String.valueOf(np-2)%></a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=String.valueOf(np-1)%>"><%=String.valueOf(np-1)%></a></td>
<td><%=String.valueOf(np)%></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=String.valueOf(maxPage)%>"><%=String.valueOf(maxPage)%></a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=String.valueOf(np+1)%>">＞</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=maxPage%>">＞＞</a></td>
</tr>
</table>

<%}else{ %>
<table>
<tr>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=1">＜＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=String.valueOf(np-1)%>">＜</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=String.valueOf(np-2)%>"><%=String.valueOf(np-2)%></a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=String.valueOf(np-1)%>"><%=String.valueOf(np-1)%></a></td>
<td><%=String.valueOf(np)%></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=String.valueOf(np+1)%>"><%=String.valueOf(np+1)%></a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=String.valueOf(np+2)%>"><%=String.valueOf(np+2)%></a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=String.valueOf(np+1)%>">＞</a></td>
<td><a href="http://localhost:8080/jyusyoroku/ListBL?page=<%=maxPage%>">＞＞</a></td>
</tr>
</table>
<%}%>
<input type="button" onclick="location.href='./add.jsp'" value="新規登録">
</form>

</body>
</html>