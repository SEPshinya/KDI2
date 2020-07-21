package jyusyoroku;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	     String name = request.getParameter("name");
	     String address = request.getParameter("address");
	     String tell = request.getParameter("tell");
	     String categoryid = request.getParameter("categoryid");
	     String id = request.getParameter("id");

	     HttpSession session = request.getSession();
	     session.setAttribute("name", name);
	     session.setAttribute("address", address);
	     session.setAttribute("tell", tell);
	     session.setAttribute("categoryid",categoryid);
	     session.setAttribute("id",id);

	     getServletContext().getRequestDispatcher("/Delete.jsp").forward(request, response);
	}
}

