package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import model.bean.UserFile;

public class UserFileDAO {
	public void uploadFile(int id,String pathFile) {
		Connection con;
		 String query = "INSERT INTO userfile (id,pathfile,uploadAt) VALUES(?,?,?)";
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltm","root","");
			 PreparedStatement prepare = con.prepareStatement(query) ;
			 prepare.setInt(1,id);
			 prepare.setString(2, pathFile);
			 prepare.setDate(3, (java.sql.Date) new java.sql.Date(System.currentTimeMillis()));
			 prepare.execute();
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
	}
	public void deleteUserFile(int id,String pathFile) {
		Connection con;
		 String query = "DELETE FROM UserFile where id = ? AND pathFile = ?";
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltm","root","");
			 PreparedStatement prepare = con.prepareStatement(query) ;
			 prepare.setInt(1,id);
			 prepare.setString(2, pathFile);
			 prepare.execute();
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
	}
	public String checkFileConvert(String fileName) {
		Connection con;
		String fileConvert = "";
		 String query = "Select pathCVFile FROM  UserFile Where pathFile = ?";
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltm","root","");
			 PreparedStatement prepare = con.prepareStatement(query);
			 prepare.setString(1,fileName);
			 ResultSet rs = prepare.executeQuery();
			 if(rs.next()) {
				 fileConvert = rs.getString(1);
			 }
			 }
			 catch(Exception ex) {
				 ex.printStackTrace();
			 }
		 return fileConvert;
	}
	public void covertedFile(String pathFile,String convetedFile) {
		Connection con;
		 String query = "Update UserFile Set pathCVFile = ?,convertedAt = ?  Where pathFile = ?";
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltm","root","");
			 PreparedStatement prepare = con.prepareStatement(query);
			 prepare.setString(1,convetedFile);
			 prepare.setDate(2,(java.sql.Date) new java.sql.Date(System.currentTimeMillis()));
			 prepare.setString(3,pathFile);
			 prepare.execute();
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }
	}
	public ArrayList<UserFile> getUserFile(int id) {
		ArrayList<UserFile> uFileList = new ArrayList<UserFile>();
		Connection con;
		 String query = "SELECT * FROM userfile where id = ?";
		 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltm","root","");
		 PreparedStatement prepare = con.prepareStatement(query);
		 prepare.setInt(1,id);
		 ResultSet rs = prepare.executeQuery();
	     while(rs.next()){
	        int userId = rs.getInt(1);
	    	String pathFile = rs.getString(2);
	    	Date uploadAt = rs.getDate(3);
	    	String pathCVFile = rs.getString(4);
	        Date convertAt = rs.getDate(5);
	    	uFileList.add(new UserFile(userId,pathFile,uploadAt,pathCVFile,convertAt));
	     }
	
	}catch(Exception ex) {
		System.out.println(ex);
	}
		 return uFileList;
	}
}
