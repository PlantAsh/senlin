package cn.edu.zucc.senlin.service;

import cn.edu.zucc.senlin.model.User;
import cn.edu.zucc.senlin.model.UserInformation;

public interface UserService {
	public String addUser(User user) throws Exception;
	
	public User loadUser(User user) throws Exception;
	
	public UserInformation getInformation(UserInformation usin) throws Exception;
	
	public String updateInformation(UserInformation usin) throws Exception;

}
