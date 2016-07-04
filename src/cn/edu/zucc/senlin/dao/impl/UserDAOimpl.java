package cn.edu.zucc.senlin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.zucc.senlin.commondao.BaseDAO;
import cn.edu.zucc.senlin.dao.UserDAO;
import cn.edu.zucc.senlin.model.User;

@SuppressWarnings("unchecked")
@Repository("userDAO")
public class UserDAOimpl implements UserDAO {
	@Resource(name="baseDAO")
	private BaseDAO baseDAO;
	
	@Override
	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		baseDAO.add(user);

	}

	@Override
	public List<User> loadUser(String userAccount) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<User> us = new ArrayList<User>();
			String hql = "from User where UserAccount = '" + userAccount + "'";
			us = (List<User>) baseDAO.findByHQL(hql);
			return us;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

}
