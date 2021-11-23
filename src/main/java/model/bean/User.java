package model.bean;

public class User {
	private int id;
	private String username;
	private String password;
	private String realname;
	
	
	public User(int id,String username,String password,String realname) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.realname = realname;
		
	}
	public User(String username,String password,String realname) {
		
		this.username = username;
		this.password = password;
		this.realname = realname;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
}
