
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
 * Servlet implementation class EditBL
 */
@WebServlet("/EditCommitBL")
public class EditCommitBL extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public EditCommitBL() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try {
			 Class.forName("com.mysql.jdbc.Driver");
		     Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hara?characterEncoding=UTF-8&serverTimezone=JST", "root", "");
		     request.setCharacterEncoding("UTF-8");
		     String name = request.getParameter("name");
		     String address = request.getParameter("address");
		     String tell = request.getParameter("tell");
		     String categoryid = request.getParameter("categoryid");



		     //UPDATE [テーブル名] SET [更新処理] WHERE [条件式]
		     PreparedStatement stmt = con.prepareStatement("update jyusyoroku set  name=?,address=?,tel=?,categoryid=?  where id='1'");

		     stmt.setString(1,name);
		     stmt.setString(2,address);
		     stmt.setString(3,tell);
		     stmt.setString(4,categoryid);
		     int line=stmt.executeUpdate();

			    if(line>0) {
			    	 out.println("できたわよ");
			      }
		     stmt.close();
		     con.close();
		}catch(Exception e){
			e.printStackTrace(out);
		}


	}
}