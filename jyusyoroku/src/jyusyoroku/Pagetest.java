package jyusyoroku;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String SelectQuery = null;

    	String maxPage="10";
    	String nowPage="2";

    	String Page1="1";
    	String Page2="2";
		String Page3="3";
		String Page4="4";
		String Page5="5";
	     HttpSession session = request.getSession();
	     session.setAttribute("Page1",Page1);
	     session.setAttribute("Page2",Page2);
	     session.setAttribute("Page3",Page3);
	     session.setAttribute("Page4",Page4);
	     session.setAttribute("Page5",Page5);












		//String SerchName;
		//int limitSta;

		/*if(nowPage==null || nowPage=="1") {
			Page1="1";
			Page2="2";
			Page3="3";
			Page4="4";
			Page5="5";
		     HttpSession session = request.getSession(true);
		     session.setAttribute("Page1",Page1);
		     session.setAttribute("Page2",Page2);
		     session.setAttribute("Page3",Page3);
		     session.setAttribute("Page4",Page4);
		     session.setAttribute("Page5",Page5);

		};*/

			/*String Page1="1";
			String Page2="2";
			String Page3="3";
			String Page4="4";
			String Page5="5";
		     HttpSession session = request.getSession();
		     session.setAttribute("Page1",Page1);
		     session.setAttribute("Page2",Page2);
		     session.setAttribute("Page3",Page3);
		     session.setAttribute("Page4",Page4);
		     session.setAttribute("Page5",Page5);

		/* };
		if(maxPage==nowPage) {
			int n=Integer.parseInt(nowPage);
			Page5=nowPage;
			Page4=""+(n-1);
			Page3=""+(n-2);
			Page2=""+(n-3);
			Page1=""+(n-4);
			HttpSession session = request.getSession(true);
		     session.setAttribute("Page1",Page1);
		     session.setAttribute("Page2",Page2);
		     session.setAttribute("Page3",Page3);
		     session.setAttribute("Page4",Page4);
		     session.setAttribute("Page5",Page5);

		};
		if(nowPage==PageB) {
			int n=Integer.parseInt(nowPage);
			Page5=""+(n+1);
			Page4=nowPage;
			Page3=""+(n-1);
			Page2=""+(n-2);
			Page1=""+(n-3);
			HttpSession session = request.getSession(true);
		     session.setAttribute("Page1",Page1);
		     session.setAttribute("Page2",Page2);
		     session.setAttribute("Page3",Page3);
		     session.setAttribute("Page4",Page4);
		     session.setAttribute("Page5",Page5);
		};

		if(nowPage==){
			int n=Integer.parseInt(nowPage);
			Page5=""+(n+2);
			Page4=""+(n+1);
			Page3=nowPage;
			Page2=""+(n-1);
			Page1=""+(n-2);
			HttpSession session = request.getSession(true);
		     session.setAttribute("Page1",Page1);
		     session.setAttribute("Page2",Page2);
		     session.setAttribute("Page3",Page3);
		     session.setAttribute("Page4",Page4);
		     session.setAttribute("Page5",Page5);
		};*/

		 getServletContext().getRequestDispatcher("/pageing.jsp").forward(request, response);

	}
}
