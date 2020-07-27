package jyusyoroku;

import java.io.IOException;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


		try {
			 Class.forName("com.mysql.jdbc.Driver");
		     Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hara?characterEncoding=UTF-8&serverTimezone=JST", "root", "");
		     request.setCharacterEncoding("UTF-8");
		     String name = request.getParameter("name");
		     String address = request.getParameter("address");
		     String tel = request.getParameter("tel");
		     String categoryid = request.getParameter("categoryid");
		     String InsQuery=null;

		     if(tel==null) {
		    	 tel=" ";
		     }

		     InsQuery="INSERT INTO jyusyoroku (name, address, tel, categoryid, delete_flg) VALUES ('"+name+"','"+ address+"','"+tel+"','"+categoryid+"','0')";

		     PreparedStatement stmt = connect.prepareStatement(InsQuery);
		     stmt.executeUpdate();


		     stmt.close();
		     connect.close();
		}catch(Exception e){

		}

		getServletContext().getRequestDispatcher("/ListBL").forward(request, response);
	}
}



