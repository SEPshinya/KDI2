package jyusyoroku;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
		//Connection connect=null;   //接続
		Statement stmt=null;       //接続
		PreparedStatement ps=null; //接続
		ResultSet rs=null;         //取得
		int listCnt=0;        //総件数
		String SelectQuery=null; //表取得
		String CntQuery=null;    //件数取得
		String nowPage=null;     //現在のページ
		String SerchName=null;  //検索用文字列 HTMLからテキストで持ってくる
		int limitSta=0;     //検索開始位置



		int id=0; //ID
		String name=null;  //名前
		String address=null; //住所
		String tel=null;    //電話番号
		String categoryid=null; //カテゴリー

		request.setCharacterEncoding("UTF-8");//文字コード
		PrintWriter out=response.getWriter();

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

//-----------検索分岐-------------------------------------------------------------
			 SerchName = request.getParameter("SerchName");
			 if(SerchName==null){
				 SelectQuery="select * from jyusyoroku where delete_flg=0 limit "+limitSta+",10";
				 //SELECT * FROM `jyusyoroku` WHERE delete_flg=0 LIMIT 10
			 }else {
				 SelectQuery="select * from jyusyoroku where delete_flg=0 like "+SerchName+" limit "+limitSta+",10";
			 };

//-----------検索分岐SQL実行-------------------------------------------------------
			 ps=connect.prepareStatement(SelectQuery);
			 rs =ps.executeQuery();
			List<String> list = new ArrayList<>();
			List<Integer> nlist = new ArrayList<>();

			 while(rs.next()) {
				 id=rs.getInt("id");
				 name=rs.getString("name");
				 address=rs.getString("address");
				 tel=rs.getString("tel");
				 categoryid=rs.getString("categoryid");

				 nlist.add(id);
				 list.add(name);
				 list.add(address);
				 list.add(tel);
				 list.add(categoryid);
			 }
//------------jspに飛ばす---------------------------------------------
				 request.setAttribute("id0",nlist.get(0));
				 request.setAttribute("name0",list.get(0));
				 request.setAttribute("address0",list.get(1));
				 request.setAttribute("tel0",list.get(2));
				 request.setAttribute("categoryid0",list.get(3));

				 request.setAttribute("id1",nlist.get(1));
				 request.setAttribute("name1",list.get(4));
				 request.setAttribute("address1",list.get(5));
				 request.setAttribute("tel1",list.get(6));
				 request.setAttribute("categoryid1",list.get(7));

				 request.setAttribute("id2",nlist.get(2));
				 request.setAttribute("name2",list.get(8));
				 request.setAttribute("address2",list.get(9));
				 request.setAttribute("tel2",list.get(10));
				 request.setAttribute("categoryid2",list.get(11));

				 request.setAttribute("id3",nlist.get(3));
				 request.setAttribute("name3",list.get(12));
				 request.setAttribute("address3",list.get(13));
				 request.setAttribute("tel3",list.get(14));
				 request.setAttribute("categoryid3",list.get(15));

				 request.setAttribute("id4",nlist.get(4));
				 request.setAttribute("name4",list.get(16));
				 request.setAttribute("address4",list.get(17));
				 request.setAttribute("tel4",list.get(18));
				 request.setAttribute("categoryid4",list.get(19));

				 request.setAttribute("id5",nlist.get(5));
				 request.setAttribute("name5",list.get(20));
				 request.setAttribute("address5",list.get(21));
				 request.setAttribute("tel5",list.get(22));
				 request.setAttribute("categoryid5",list.get(23));

				 request.setAttribute("id6",nlist.get(6));
				 request.setAttribute("name6",list.get(24));
				 request.setAttribute("address6",list.get(25));
				 request.setAttribute("tel6",list.get(26));
				 request.setAttribute("categoryid6",list.get(27));

				 request.setAttribute("id7",nlist.get(7));
				 request.setAttribute("name7",list.get(28));
				 request.setAttribute("address7",list.get(29));
				 request.setAttribute("tel7",list.get(30));
				 request.setAttribute("categoryid7",list.get(31));

				 request.setAttribute("id8",nlist.get(8));
				 request.setAttribute("name8",list.get(32));
				 request.setAttribute("address8",list.get(33));
				 request.setAttribute("tel8",list.get(34));
				 request.setAttribute("categoryid8",list.get(35));

				 request.setAttribute("id9",nlist.get(9));
				 request.setAttribute("name9",list.get(36));
				 request.setAttribute("address9",list.get(37));
				 request.setAttribute("tel9",list.get(38));
				 request.setAttribute("categoryid9",list.get(39));


//-----------close-----------------------------------------------------------------
				ps.close();
				stmt.close();
				rs.close();
			    connect.close();
			}catch(Exception e){
				e.printStackTrace(out);
			}
//---------------ページング用---------------------
		String page1=null;
		String page2=null;
		String page3=null;
		String page4=null;
		String page5=null;
		String prev=null;
		String next=null;
//---------------ページングの処理----------------------------
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

//---------------最大ページを計算-----------------------------
		int maxPage=listCnt/10;
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
//			1から３ページまで
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
//3ページ以上max-2未満
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
//maxpage-2からのページ
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
