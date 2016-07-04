package cn.edu.zucc.senlin.dao;

import java.util.List;

import cn.edu.zucc.senlin.model.UserInformation;

public interface UserInformationDAO {
	public void addInformation(UserInformation usin) throws Exception;
	
	public void updateInformation(UserInformation usin) throws Exception;
	
	public List<UserInformation> getInformation(String userAccount) throws Exception;

}
