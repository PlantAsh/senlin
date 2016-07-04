package cn.edu.zucc.senlin.dao;

import java.util.List;

import cn.edu.zucc.senlin.commondao.BaseDAO;
import cn.edu.zucc.senlin.model.User;

public interface UserDAO extends BaseDAO<User> {
	
	public List<User> loadUser(String userAccount) throws Exception;

}
