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
 * Servlet implementation class DeleteCommit
 */
@WebServlet("/DeleteCommit")
public class DeleteCommit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCommit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			 Class.forName("com.mysql.jdbc.Driver");
		     Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hara?characterEncoding=UTF-8&serverTimezone=JST", "root", "");
		     request.setCharacterEncoding("UTF-8");
		     String id = request.getParameter("id");


//UPDATE テーブル名 SET 列名 = データ, 列名 = データ ,.... ;

		     PreparedStatement stmt = con.prepareStatement("UPDATE jyusyoroku SET delete_flg=1 where id=" +"'"+ id +"'");

		     con.commit();
		     stmt.close();
		     con.close();
		}catch(Exception e){
		}
		getServletContext().getRequestDispatcher("/ListBL").forward(request, response);
	}
}

