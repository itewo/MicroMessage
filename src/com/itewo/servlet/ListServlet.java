package com.itewo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itewo.service.ListService;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
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
		//设置编码 ;如未添加字符过滤器则需要设置编码
//		request.setCharacterEncoding("UTF-8");
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
