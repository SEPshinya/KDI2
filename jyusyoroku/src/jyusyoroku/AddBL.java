package jyusyoroku;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class AddBL
 */
@WebServlet("/AddBL")
public class AddBL extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
     public AddBL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
	     String name = request.getParameter("name");
	     String address = request.getParameter("address");
	     String tell = request.getParameter("tell");
	     String categoryid = request.getParameter("categoryid");

	     request.setAttribute("name", name);
	     request.setAttribute("address", address);
	     request.setAttribute("tell", tell);
	     request.setAttribute("categoryid",categoryid);

	     getServletContext().getRequestDispatcher("/addCheck.jsp").forward(request, response);

	}
}