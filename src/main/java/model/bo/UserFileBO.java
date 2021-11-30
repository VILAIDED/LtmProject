package model.bo;

import java.util.ArrayList;

import model.bean.UserFile;
import model.dao.UserFileDAO;

public class UserFileBO {
	UserFileDAO uFileDao = new UserFileDAO();
	public ArrayList<UserFile> getUserFileBO(int id){
		return uFileDao.getUserFile(id);
	}
	public void upLoadFileBO(int id,String pathFile) {
		uFileDao.uploadFile(id, pathFile);
	}
	public void convertFile(String pathFile,String pathCVFile) {
		uFileDao.covertedFile(pathFile, pathCVFile);
	}
	public String checkConvert(int id,String fileName) {
		return uFileDao.checkFileConvert(id,fileName);
	}
	public void deleteUserFileBO(String path, int id) {
		uFileDao.deleteUserFile(id, path);
		
	}
	
}
