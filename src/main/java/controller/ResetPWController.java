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
 * Servlet implementation class ResetPWController
 */
@WebServlet("/reset_password")
public class ResetPWController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPWController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String token = (String)session.getAttribute("token");
		if(token == null) {
			response.sendRedirect(request.getContextPath() + "/login");
		}else {
			RequestDispatcher rd =  getServletContext().getRequestDispatcher("/resetPw.jsp");
			rd.forward(request,response);
		}
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldPw = request.getParameter("oldPw");
		String newPw = request.getParameter("newPw");
		System.out.print(newPw);
		AuthBO authBO = new AuthBO();
		HttpSession session = request.getSession();
		String token = (String)session.getAttribute("token");
		String newToken = authBO.resetPassword(token, oldPw, newPw);
		if(newToken != "current password is not correct") {
			session.setAttribute("token", newToken);
			response.sendRedirect(request.getContextPath() + "/home");
		}
		else {
		RequestDispatcher rd =  getServletContext().getRequestDispatcher("/resetPw.jsp");
		rd.forward(request,response);
		}
	}

}
