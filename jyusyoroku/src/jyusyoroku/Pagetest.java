package jyusyoroku;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Pagetest
 */
@WebServlet("/Pagetest")
public class Pagetest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pagetest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();


		try {
			int listCnt = 0;
			//String SelectQuery = null;
			String CntQuery="SELECT COUNT(*) FROM jyusyoroku";
			//String nowPage;
			//String SerchName;
			//int limitSta;

			 Class.forName("com.mysql.jdbc.Driver");
		     Connection  connect= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hara?characterEncoding=UTF-8&serverTimezone=JST", "root", "");
		     request.setCharacterEncoding("UTF-8");

		    Statement stmt=connect.createStatement();
		   // PreparedStatement ps = connect.prepareStatement(SelectQuery);
		    ResultSet rs = stmt.executeQuery(CntQuery);
		    rs.getInt(listCnt);
		    
		    




		     stmt.close();
		     connect.close();
		}catch(Exception e){
			e.printStackTrace(out);
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
