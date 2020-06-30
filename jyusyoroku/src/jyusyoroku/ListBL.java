package jyusyoroku;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		ResultSet rs;
		PreparedStatement ps;
		int listCnt=0; //総件数
		String CntQuery;
		String SelectQuery=null;
		Connection connect=null;
		Statement stmt;
		String nowPage=null; //今のpage
		int limitSta;//検索開始件数
		String Serchname=null;
		int n=0;
		ArrayList<Integer> Idlist=new ArrayList<Integer>();
		ArrayList<String> namelist=new ArrayList<String>();
		ArrayList<String> addlist=new ArrayList<String>();
		ArrayList<String> tellist=new ArrayList<String>();
		ArrayList<String> catlist=new ArrayList<String>();
		String page1=null;
		String page2=null;
		String page3=null;
		String page4=null;
		String page5=null;
		String prev=null;
		String next=null;

		nowPage = request.getParameter("page");
		if(nowPage==null) {
		nowPage="1";
		}


		int np =Integer.parseInt(nowPage);
		if(np>1) {
		limitSta=(np-1)*10;
		}else{
			limitSta=np*10;
		};

		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 request.setCharacterEncoding("UTF-8");
			 connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hara?characterEncoding=UTF-8&serverTimezone=JST", "root", "");
			 CntQuery="SELECT COUNT(*) FROM jyusyoroku";
			 stmt=connect.createStatement();
			 rs = stmt.executeQuery(CntQuery);
			 rs.next();
			 listCnt = rs.getInt("1");

			 //検索した？
			 Serchname = request.getParameter("Serchname");
			 if(Serchname==null){
				 SelectQuery="select * from jyusyoroku where delete_flg=0 limit "+limitSta+",10";
				 //SELECT * FROM `jyusyoroku` WHERE delete_flg=0 LIMIT 10
			 }else {
				 SelectQuery="select * from jyusyoroku where delete_flg=0 like "+Serchname+" limit "+limitSta+",10";
			 };

			 ps=connect.prepareStatement(SelectQuery);
			 rs =ps.executeQuery();

			 while(rs.next()) {

				 int id=rs.getInt("id");
				 Idlist.add(id);
				 String name=rs.getString("name");
				 namelist.add(name);
				 String address=rs.getString("address");
				 addlist.add(address);
				 String tel = rs.getString("tel");
				 tellist.add(tel);
				 String categoryid=rs.getString("categoryid");
				 catlist.add(categoryid);

				request.setAttribute("id"+n,Idlist.get(n));
				request.setAttribute("name"+n, namelist.get(n));
				request.setAttribute("address"+n, addlist.get(n));
				request.setAttribute("tel"+n, tellist.get(n));
				request.setAttribute("categoryid"+n,catlist.get(n));
				n++;
			 }

			ps.close();
			stmt.close();
			rs.close();
		    connect.close();
		}catch(Exception e){
			e.printStackTrace(out);
		}

		int lc =listCnt;
		int maxPage=lc/10;                  //最大ページを計算

		int mp =maxPage;
		request.setAttribute("Max", maxPage);

		if(np==mp){
		next=""+mp;
		request.setAttribute("next",next);
		}else {
			next=""+(np+1);
			request.setAttribute("next",next);
		};

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
		request.setAttribute("nowPage", nowPage);

		getServletContext().getRequestDispatcher("/List.jsp").forward(request, response);

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
			request.setAttribute("nowPage", nowPage);

			getServletContext().getRequestDispatcher("/List.jsp").forward(request, response);
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
		request.setAttribute("nowPage", nowPage);
	    getServletContext().getRequestDispatcher("/List.jsp").forward(request, response);
	}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}