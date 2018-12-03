package com.book_manage.servlet.cart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book_manage.entity.User;
import com.book_manage.service.UserService;
import com.book_manage.util.Cart;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int id=Integer.parseInt(request.getParameter("book_id"));
		System.out.println("id"+id);
		UserService ps=new UserService();
//		User ps=new User();
//		Product p=ps.findProductById(id);
		User p=ps.findUserById(id);
		System.out.println(p);
		HttpSession session=request.getSession();
		Cart c=(Cart)session.getAttribute("cart");
		if(c==null) {
			c=new Cart();
		}
		c.addCartItem(p);
		
		session.setAttribute("cart", c);
		System.out.println();
		request.getRequestDispatcher("ShowCartServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
