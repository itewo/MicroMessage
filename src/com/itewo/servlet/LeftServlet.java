package com.itewo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itewo.service.ListService;

/**
 * Servlet implementation class LeftServlet
 */
public class LeftServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeftServlet() {
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
		String type = request.getParameter("type");
		
		if(type!=null&&"datalist".equals(type)){//数据列表请求
			this.showDateList(request, response);
		}
		
	}
	
	/**
	 * 返回数据列表信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void showDateList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取页面的值
		String command =request.getParameter("command");
		String description =request.getParameter("description");
		//向页面返回值
		request.setAttribute("command",command);
		request.setAttribute("description",description);
		//查询消息列表并传给页面
		ListService  listservice = new ListService();
		request.setAttribute("countnum", listservice.queryMessageList(command, description).size());
		request.setAttribute("messageList", 	listservice.queryMessageList(command, description));
		//跳转到指定的页面
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
	}
	

}
