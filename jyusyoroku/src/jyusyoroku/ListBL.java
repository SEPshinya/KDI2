package jyusyoroku;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListBL
 */
@WebServlet("/ListBL")
public class ListBL extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		ResultSet rs;
		PreparedStatement ps;
		String listCnt=null; //総件数
		String CntQuery;
		String SelectQuery=null;
		Connection connect=null;
		Statement stmt;
		String nowPage=null; //今のpage
		int limitSta =2;//検索開始件数
		String Serchname=null;

		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 request.setCharacterEncoding("UTF-8");
			 connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hara?characterEncoding=UTF-8&serverTimezone=JST", "root", "");
			 CntQuery="SELECT COUNT( * ) FROM jyusyoroku";
			 stmt=connect.createStatement();
			 rs = stmt.executeQuery(CntQuery);
			 rs.next();
			 rs.getInt(listCnt);

			 //検索した？
			 Serchname = request.getParameter("Serchname");
			 if(Serchname==null){
				 SelectQuery="select * from jyusyoroku where delete_flg=0 limit"+limitSta+",10";
			 }else {
				 SelectQuery="select * from jyusyoroku where delete_flg=0like"+Serchname+"limit"+limitSta+",10";
			 };

			 ps=connect.prepareStatement(SelectQuery);
			 rs =ps.executeQuery();
			 while(rs.next()) {
				 int id=rs.getInt("id");

			 }

			request.setAttribute("listCnt",listCnt);
			request.setAttribute("Result",rs);
			request.setAttribute("page",nowPage);

			ps.close();
			stmt.close();
			rs.close();
		    connect.close();
		}catch(Exception e){
			e.printStackTrace(out);
		}




	}




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
