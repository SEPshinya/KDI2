package jyusyoroku;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddCommitBL
 */
@WebServlet("/AddCommitBL")
public class AddCommitBL extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommitBL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out=response.getWriter();
	    //response.setContentType("text/html; charset=Shift_JIS");


		try {
			 Class.forName("com.mysql.jdbc.Driver");
		     Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hara?characterEncoding=UTF-8&serverTimezone=JST", "root", "");
		     request.setCharacterEncoding("UTF-8");
		     String name = request.getParameter("name");
		     String address = request.getParameter("address");
		     String tell = request.getParameter("tell");
		     String categoryid = request.getParameter("categoryid");




		     PreparedStatement stmt = con.prepareStatement( "insert into jyusyoroku values (null,?,?,?,?,0)");

		     stmt.setString(1,name);
		     stmt.setString(2,address);
		     stmt.setString(3,tell);
		     stmt.setString(4,categoryid);



		     stmt.close();
		     con.close();
		}catch(Exception e){
			
		}


	}

}



