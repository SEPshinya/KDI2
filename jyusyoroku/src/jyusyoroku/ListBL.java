package jyusyoroku;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Connection connect=null;  //接続
    	request.setCharacterEncoding("UTF-8");
		Statement stmt=null;       //接続
		PreparedStatement ps=null; //接続
		ResultSet rs=null;         //取得
		int listCnt=0;            //総件数
		String SelectQuery=null; //表取得
		String CntQuery=null;    //件数取得
		String nowPage=null;     //現在のページ
		String SerchName=null;   //検索用文字列
		int limitSta=0;          //検索開始位置

//-----------検索開始位置-----------------------------------------------------
		nowPage = request.getParameter("page");
		if(nowPage==null) {
		nowPage="1";
		}
		int np =Integer.parseInt(nowPage);
		request.setAttribute("np", np);
		if(np>1) {
		limitSta=(np-1)*10;
		};


//-----------データベース接続-----------------------------------------------------
		try {
			 Class.forName("com.mysql.jdbc.Driver");
		     Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hara?characterEncoding=UTF-8&serverTimezone=JST", "root", "");

		     //全件数取得
			 CntQuery="select count(*) id FROM jyusyoroku where delete_flg=0";
			 stmt=connect.createStatement();
			 rs = stmt.executeQuery(CntQuery);
			 rs.next();
			 listCnt = rs.getInt("id");
			 request.setAttribute("listCnt", listCnt);

//-----------検索分岐-------------------------------------------------------------
			 SerchName = request.getParameter("SerchName");
			 if(SerchName==null){
				 SelectQuery="select * from jyusyoroku where delete_flg=0 limit "+limitSta+",10";
				 //SELECT * FROM `jyusyoroku` WHERE delete_flg=0 LIMIT 10
			 }else {
				 SelectQuery="select * from jyusyoroku where delete_flg=0 and address like "+"'"+SerchName+"'"+" limit "+limitSta+",10";
			 };
//-----------検索分岐SQL実行-------------------------------------------------------
			 ps=connect.prepareStatement(SelectQuery);
			 rs =ps.executeQuery();
//------------rsをjspに飛ばす---------------------------------------------
			 request.setAttribute("rs", rs);

			}catch(Exception e){

			}

	    getServletContext().getRequestDispatcher("/List.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
