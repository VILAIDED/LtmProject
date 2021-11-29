package model.bean;

import java.util.Date;

public class UserFile {
	private int id;
	private String pathFile;
	private Date uploadAt;
	private String pathCVFile;
	private Date convertAt;
	public UserFile(int id,String pathFile,Date uploadAt,String pathCVFile,Date convertAt) {
		this.id = id;
		this.pathFile = pathFile;
		this.uploadAt = uploadAt;
		this.pathCVFile = pathCVFile;
		this.convertAt = convertAt;
	}
	public int getId() {
	return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPathFile() {
		return pathFile;
	}
	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}
	public Date getUploadAt() {
		return uploadAt;
	}
	public void setUploadAt(Date uploadAt) {
		this.uploadAt = uploadAt;
	}
	public String getPathCVFile() {
		return pathCVFile;
	}
	public void setPathCVFile(String pathCVFile) {
		this.pathCVFile = pathCVFile;
	}
	public Date getConvertAt() {
		return convertAt;
	}
	public void SetConvertAt(Date convertAt) {
		this.convertAt = convertAt;
	}
	
}
