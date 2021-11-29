package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.bean.UserFile;
import model.bo.AuthBO;
import model.bo.UserFileBO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String token = (String)session.getAttribute("token");
		UserFileBO uFile = new UserFileBO();
		AuthBO authBO = new AuthBO();
		if(token == null || !authBO.validateJWTToken(token)) {
			session.removeAttribute("token");
			response.sendRedirect(request.getContextPath() + "/login");
		}else {
		User user = authBO.getUser(token);
		ArrayList<String> lastUp = (ArrayList<String>)session.getAttribute("fileT");
		
		if(lastUp != null) {
		ArrayList<String>  fileStatus = new ArrayList<String>();
		String pathFile = "";
		for(int i = 0 ; i < lastUp.size() ; i++) {
			pathFile = uFile.checkConvert(lastUp.get(i));
			if(pathFile == null)  fileStatus.add(lastUp.get(i));
			else  fileStatus.add(pathFile+".mp3");
			File f = new File(fileStatus.get(i));
		}
		request.setAttribute("fileT", fileStatus);
		}
//		session.removeAttribute("fileT");
//		request.setAttribute("uList", uFList);
		request.setAttribute("user", user);
		RequestDispatcher rd =  getServletContext().getRequestDispatcher("/home.jsp");
		rd.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
