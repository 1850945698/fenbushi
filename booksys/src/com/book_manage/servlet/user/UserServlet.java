package com.book_manage.servlet.user;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1、获取请求页码参数
//				String pageNum=request.getParameter("pageNum");
//				int num=0;
//				if(pageNum==null || pageNum.equals("")){
//					num=1;
//				}else{
//					num=Integer.parseInt(pageNum);
//				}
				//2、根据页码查询相关数据
				UserService ps=new UserService();
				//int count=ps.findCountByPage();
				List<User> list=new ArrayList<User>();
				list=ps.findByPage();
//				Page<User> p=new Page<User>(num, 2);
//				p.setList(list);
////				p.setTotalCount(count);
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
