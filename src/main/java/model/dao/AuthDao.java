package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.bean.User;

public class AuthDao {
	public User findUser(String username) {
		User user = null;
		Connection con;
		 String query = "SELECT * FROM users where username = ?";
		 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltm","root","");
		 PreparedStatement prepare = con.prepareStatement(query);
		 prepare.setString(1,username);
		 ResultSet rs = prepare.executeQuery();
	     if(rs.next()){
	        int id = rs.getInt(1);
	    	String uName = rs.getString(2);
	    	String pw = rs.getString(3);
	    	String rName = rs.getString(4);
	    	user = new User(id,uName,pw,rName);
	     }
	
	}catch(Exception ex) {
		System.out.println(ex);
	}
			return user;
}
	public User getUserById(int userId) {
		User user = null;
		Connection con;
		 String query = "SELECT * FROM users where id = ?";
		 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltm","root","");
		 PreparedStatement prepare = con.prepareStatement(query);
		 prepare.setInt(1,userId);
		 ResultSet rs = prepare.executeQuery();
	     if(rs.next()){
	        int id = rs.getInt(1);
	    	String uName = rs.getString(2);
	    	String pw = rs.getString(3);
	    	String rName = rs.getString(4);
	    	user = new User(id,uName,pw,rName);
	     }
	
	}catch(Exception ex) {
		System.out.println(ex);
	}
			return user;
	}
	public void insertUser(User user) {
		Connection con;
		 String query = "INSERT INTO users (username,password,realname) VALUES(?,?,?)";
		 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ltm","root","");
		 PreparedStatement prepare = con.prepareStatement(query);
		 prepare.setString(1,user.getUsername());
		 prepare.setString(2,user.getPassword());
		 prepare.setString(3,user.getRealname());
		 prepare.execute();
		 con.close();
		 
		 }catch(Exception ex) {
			 System.out.println(ex);
		 }
	}
}
