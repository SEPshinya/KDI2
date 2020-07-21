package jyusyoroku;
import java.io.IOException;
//import java.io.PrintWriter;

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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nowpage = request.getParameter("page");
		if(nowpage==null) {
			nowpage="1";
		};
		String maxpage ="20";
		String page1;
		String page2;
		String page3;
		String page4;
		String page5;
		String prev;
		String next;

		int np =Integer.parseInt(nowpage);
		int mp =Integer.parseInt(maxpage);
		request.setAttribute("Max", maxpage);

		if(np==mp){
		next=""+mp;
		request.setAttribute("next",next);
		}else {
			next=""+(np+1);
			request.setAttribute("next",next);
		};

		////////////////////////////////////////////

		if(np==1){
		prev="1";
		request.setAttribute("prev",prev);
		}else {
			prev=""+(np-1);
			request.setAttribute("prev",prev);
		};

		if(np<=3) {
			page1="1";
			page2="2";
			page3="3";
			page4="4";
			page5="5";


		request.setAttribute("page1", page1);
		request.setAttribute("page2", page2);
		request.setAttribute("page3", page3);
		request.setAttribute("page4", page4);
		request.setAttribute("page5", page5);
		request.setAttribute("nowPage", nowpage);

		getServletContext().getRequestDispatcher("/pageing.jsp").forward(request, response);

		}else

		if(np>3 && np<=mp-2) {
			page1=""+(np-2);
			page2=""+(np-1);
			page3=""+np;
			page4=""+(np+1);
			page5=""+(np+2);


			request.setAttribute("page1", page1);
			request.setAttribute("page2", page2);
			request.setAttribute("page3", page3);
			request.setAttribute("page4", page4);
			request.setAttribute("page5", page5);
			request.setAttribute("nowPage", nowpage);


			getServletContext().getRequestDispatcher("/pageing.jsp").forward(request, response);
		}else

		if(np<=mp&&np>=mp-2){

		page1=""+(mp-4);
		page2=""+(mp-3);
		page3=""+(mp-2);
		page4=""+(mp-1);
		page5=""+(mp);

		request.setAttribute("page1", page1);
		request.setAttribute("page2", page2);
		request.setAttribute("page3", page3);
		request.setAttribute("page4", page4);
		request.setAttribute("page5", page5);
		request.setAttribute("nowPage", nowpage);

	    getServletContext().getRequestDispatcher("/pageing.jsp").forward(request, response);

	}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//String nowpage = request.getParameter("page");
		//HttpSession session = request.getSession();
	    //session.setAttribute("nowPage", nowpage);
	    //getServletContext().getRequestDispatcher("/pageing.jsp").forward(request, response);

	}

}