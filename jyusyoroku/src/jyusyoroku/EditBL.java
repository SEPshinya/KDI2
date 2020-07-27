package jyusyoroku;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditBL
 */
@WebServlet("/EditBL")
public class EditBL extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public EditBL() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
	     String name = request.getParameter("name");
	     String address = request.getParameter("address");
	     String tell = request.getParameter("tell");
	     String categoryid = request.getParameter("categoryid");
	     String id=request.getParameter("id");

	     HttpSession session = request.getSession();
	     session.setAttribute("name", name);
	     session.setAttribute("address", address);
	     session.setAttribute("tell", tell);
	     session.setAttribute("categoryid",categoryid);
	     session.setAttribute("id",id);

	     getServletContext().getRequestDispatcher("/EditCheck.jsp").forward(request, response);

	}
}
