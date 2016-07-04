package cn.edu.zucc.senlin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.zucc.senlin.commondao.BaseDAOimpl;
import cn.edu.zucc.senlin.dao.UserDAO;
import cn.edu.zucc.senlin.model.User;

@Repository("userDAO")
public class UserDAOimpl extends BaseDAOimpl<User> implements UserDAO {

	@Override
	public List<User> loadUser(String userAccount) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<User> us = new ArrayList<User>();
			String hql = "from User where UserAccount = '" + userAccount + "'";
			us = (List<User>) findByHQL(hql);
			return us;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

}
