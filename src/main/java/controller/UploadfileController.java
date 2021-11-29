package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import convert.mp3Thread;
import model.bean.User;
import model.bo.AuthBO;
import model.bo.UserFileBO;

/**
 * Servlet implementation class UploadfileController
 */
@WebServlet("/uploadfile")
public class UploadfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String SAVE_DIRECTORY = "uploadDir";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ServletContext ctx = getServletContext();
//		File file = new File("E:\\learning\\Workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\TestUpfile\\fileUp\\y2mate.mp4");
//		if(!file.exists()){
//			throw new ServletException("File doesn't exists on server.");
//		}
//		InputStream fs = new FileInputStream(file);
//		String mimetype = ctx.getMimeType(file.getAbsolutePath());
//		if(mimetype == null) {
//			mimetype = "application/octet-stream";
//		}
//		response.setContentType(mimetype);
//		response.setContentLength((int)file.length());
//		response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName()+ "\"");
//		ServletOutputStream os = response.getOutputStream();
//		byte[] bufferData = new byte[1024];
//		int read = 0;
//		while((read = fs.read(bufferData))!= -1){
//			os.write(bufferData,0,read);
//		}
//		os.flush();
//		os.close();
//		fs.close();
//		
		RequestDispatcher rd =  getServletContext().getRequestDispatcher("/home.jsp");
		rd.forward(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> dataUpload = new ArrayList<String>();
		HttpSession session = request.getSession();
		String token = (String)session.getAttribute("token");
		AuthBO authBO = new AuthBO();
		User user = authBO.getUser(token);
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
		    DiskFileItemFactory factory = new DiskFileItemFactory();
		    factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		    ServletFileUpload upload = new ServletFileUpload(factory);
		    String uploadPath = getServletContext().getRealPath("") 
		    	      + File.separator + "fileUp\\" + user.getUsername();
		    File uploadDir = new File(uploadPath);
		    System.out.println("file path day " + uploadPath);
		    if(!uploadDir.exists()) {
		    	uploadDir.mkdir();
		    }
		    List<FileItem> formItems = upload.parseRequest(request);
		    if(formItems != null && formItems.size() > 0) {
		        UserFileBO uFileBO = new UserFileBO();
		    	for(FileItem item : formItems) {
		    		if(!item.isFormField()) {
		    			String fileName = new File(item.getName()).getName();
		    			fileName = FilenameUtils.removeExtension(fileName);
		    			String filePath = uploadPath + File.separator + fileName;
		    			File StoreFile = new File(filePath + ".mp4");
		    			if(StoreFile.exists()) {
		    				StoreFile.delete();
		    				File mp3F = new File(filePath + ".mp3");
		    				if(mp3F.exists()) mp3F.delete();
		    				uFileBO.deleteUserFileBO(fileName,user.getId());
		    			}
		    				item.write(StoreFile);
		    				uFileBO.upLoadFileBO(user.getId(), fileName);
			    			
			    			new mp3Thread(filePath +".mp4",uploadPath + "\\" + fileName,fileName).start();
		    			    dataUpload.add(fileName);
		    			
		    			
		    		}	
		    	}
		    }
		    
		   
		}catch (FileUploadException e) {
			//out.write("Exception in uploading file.");
		} catch (Exception e) {
			//out.write("Exception in uploading file.");
		}
			session.setAttribute("fileT", dataUpload);
			response.sendRedirect(request.getContextPath() + "/home");
	}
	}


}
