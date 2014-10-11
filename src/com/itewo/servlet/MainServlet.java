package com.itewo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于主页 显示请求放回具体的页面
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取页面的值
		String location =request.getParameter("location");
		if("top".equals(location)){
			request.getRequestDispatcher("/WEB-INF/jsp/top.jsp").forward(request, response);
		}else if("left".equals(location)){
			request.getRequestDispatcher("/WEB-INF/jsp/left.jsp").forward(request, response);
		}else if("index".equals(location)){
			request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		}else if("main".equals(location)){
			request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
		}
	}

}
