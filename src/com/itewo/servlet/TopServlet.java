package com.itewo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 顶部链接请求Servlet
 */
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopServlet() {
        super();
    }

	/**
	 *  doGet 返回于doPost进行处理得到的请求
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * doPost请求；进行分发请求至具体的方法进行处理
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		if("logout".equals(type)){
			this.logout(request, response);
		}
		
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//移除指定的Session
		request.getSession().removeAttribute("username");
		//跳转到登录页面
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
