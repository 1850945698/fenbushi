package com.book_manage.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book_manage.entity.User;
import com.book_manage.service.UserService;
import com.book_manage.entity.Page;


/**
 * Servlet implementation class UserPageServlet
 */
@WebServlet("/c")
public class UserPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取请求页参数
				String pageNum=request.getParameter("pageNum");
				int num=0;
				if(pageNum==null || pageNum.equals("")){
					num=1;
				}else{
					num=Integer.parseInt(pageNum);
				}
				//调用业务逻辑层对象，处理结果实现跳转
				UserService ps=new UserService();
				int count=ps.findCountByPage();
				List<User> list=ps.findByPage();

				request.setAttribute("page", list);
				request.getRequestDispatcher("booklist.jsp").forward(request, response);
					}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
