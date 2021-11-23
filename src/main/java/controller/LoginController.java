package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bo.AuthBO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String token = (String)request.getAttribute("token");
		if(token != null) {
			response.sendRedirect(request.getContextPath() + "/home");
		}
		RequestDispatcher rd =  getServletContext().getRequestDispatcher("/login.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AuthBO authBO = new AuthBO();
		String token = authBO.login(username,password);
		HttpSession session = request.getSession();
		System.out.println("token" + token);
		if(token != "user or password is invalid") {
			session.setAttribute("token",token);
			response.sendRedirect(request.getContextPath() + "/home");
		}else {
		RequestDispatcher rd =  getServletContext().getRequestDispatcher("/login.jsp");
		rd.forward(request,response);
		}
	}

}
