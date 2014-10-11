package com.itewo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itewo.service.LoginService;

	/**
	 * 系统登录
	 * @author E540
	 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * doGet 请求
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			this.doPost(request, response);
	}

	/**
	 * doPost 请求
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				//获取页面的值
				String username =request.getParameter("username");
				String password =request.getParameter("password");
				LoginService loginservice = new LoginService();
				boolean flag =loginservice.countUser(username, password);
				//使用from提交方式返回结果
				if(flag){  
						//设置Session
						request.getSession().setAttribute("username", username);
						//跳转到指定的页面
						request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
					}else{
						request.setAttribute("msg","flag");
					}
					/*	//为ajax 返回值；
					PrintWriter out= response.getWriter();
					out.print(flag);
					out.flush();
					out.close();
					//ajax 方式结束
					 */
	}

}
