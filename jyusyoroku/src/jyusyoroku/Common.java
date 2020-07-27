package jyusyoroku;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Common
 */
@WebServlet("/Common")
public class Common extends HttpServlet {
	 static void getErr(String name,String address,String tel) {
		 String ERRMSG_NAME01="名前は全角20文字以内で入力してください";
		 String ERRMSG_NAME02="名前は必須項目です";
		 String ERRMSG_ADDRESS01="住所は全角40文字以内で入力してください";
		 String ERRMSG_ADDRESS02="住所は必須項目です";
		 String ERRMSG_TEL01="電話番号は「000-0000-0000」の形式で入力してください";
		 String returnVal=null;

		 byte num=40;
		 if(name.getBytes().length>num) {
			 returnVal=ERRMSG_NAME01;
		 }else if(name.getBytes().length==0) {
			 returnVal=ERRMSG_NAME02;
		 }else if(address.getBytes().length>80) {
			 returnVal=ERRMSG_ADDRESS01;
		 }else if(address.getBytes().length>80) {

	 }
    public Common() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
