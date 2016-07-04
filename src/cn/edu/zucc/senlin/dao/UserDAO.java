package cn.edu.zucc.senlin.dao;

import java.util.List;

import cn.edu.zucc.senlin.model.User;

public interface UserDAO {
	public void addUser(User user) throws Exception;
	
	public List<User> loadUser(String userAccount) throws Exception;

}
