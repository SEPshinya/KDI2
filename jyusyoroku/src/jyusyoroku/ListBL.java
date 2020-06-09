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
import javax.servlet.http.HttpSession;
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

		try {
			 Class.forName("com.mysql.jdbc.Driver");
		     Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hara?characterEncoding=UTF-8&serverTimezone=JST", "root", "");
		     request.setCharacterEncoding("UTF-8");

		     Statement stmt = con.createStatement();
		     String sql = "SELECT * FROM jyusyoroku";
		     ResultSet rs = stmt.executeQuery(sql);

		      while(rs.next()){
		        int id = rs.getInt("id");
		        String name = rs.getString("name");
		        String address = rs.getString("address");
		        String tel = rs.getString("tel");
		        String categoryid = rs.getString("categoryid");
		        String delete_flg = rs.getString("delete_flg");

		        HttpSession session = request.getSession();
		         session.setAttribute("id", id);
			     session.setAttribute("name", name);
			     session.setAttribute("address", address);
			     session.setAttribute("tell", tel);
			     session.setAttribute("categoryid",categoryid);
			     session.setAttribute("delete_flg", delete_flg);
		      }
		}catch(Exception e){
			e.printStackTrace(out);
		}
		getServletContext().getRequestDispatcher("/list.jsp").forward(request, response);
	}
}


