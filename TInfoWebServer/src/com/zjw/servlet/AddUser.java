package com.zjw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjw.dao.UserInfoDAO;
import com.zjw.model.UserInfo;

import config.Constant;

public class AddUser extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddUser() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String username=new String(request.getParameter("account").getBytes("iso-8859-1"),"utf-8");
		String password=new String(request.getParameter("pwd").getBytes("iso-8859-1"),"utf-8");
		String name=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		String addr=new String(request.getParameter("addr").getBytes("iso-8859-1"),"utf-8");
		String tel=new String(request.getParameter("tel").getBytes("iso-8859-1"),"utf-8");

		if(UserInfoDAO.isExistUserName(username)){
			out.print(Constant.RESPONSE_ERROR);
		}else {
			UserInfo userInfo =new UserInfo();
			userInfo.setPwd(password);
			userInfo.setAccount(username);
			userInfo.setAddr(addr);
			userInfo.setName(name);
			userInfo.setTel(tel);
			UserInfoDAO.add(userInfo);
			out.print(Constant.RESPONSE_SUCCESS);
		}
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
