package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.bo.AuthBO;

/**
 * Servlet implementation class DownloadController
 */
@WebServlet("/download")
public class DownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		AuthBO authBO = new AuthBO();
		HttpSession session = request.getSession();
		String token = (String)session.getAttribute("token");
		User user = authBO.getUser(token);
		String uploadPath = getServletContext().getRealPath("") 
	    	      + File.separator + "fileUp\\" + user.getUsername();
		String filename = request.getParameter("pathfile");
		
		File file = new File(uploadPath + "\\" + filename);
		if(!file.exists()){
			throw new ServletException("File doesn't exists on server.");
		}
		InputStream fs = new FileInputStream(file);
		String mimetype = ctx.getMimeType(file.getAbsolutePath());
		if(mimetype == null) {
			mimetype = "application/octet-stream";
		}
		response.setContentType(mimetype);
		response.setContentLength((int)file.length());
		response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName()+ "\"");
		ServletOutputStream os = response.getOutputStream();
		byte[] bufferData = new byte[1024];
		int read = 0;
		while((read = fs.read(bufferData))!= -1){
			os.write(bufferData,0,read);
		}
		os.flush();
		os.close();
		fs.close();
		
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
