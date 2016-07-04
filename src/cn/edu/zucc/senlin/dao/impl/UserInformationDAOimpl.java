package cn.edu.zucc.senlin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.zucc.senlin.commondao.BaseDAO;
import cn.edu.zucc.senlin.dao.UserInformationDAO;
import cn.edu.zucc.senlin.model.UserInformation;

@SuppressWarnings("unchecked")
@Repository("userInformationDAO")
public class UserInformationDAOimpl implements UserInformationDAO {
	@Resource(name="baseDAO")
	private BaseDAO baseDAO;

	@Override
	public List<UserInformation> getInformation(String userAccount) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<UserInformation> us = new ArrayList<UserInformation>();
			String hql = "from UserInformation where UserAccount = '" + userAccount + "'";
			us = (List<UserInformation>) baseDAO.findByHQL(hql);
			return us;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void addInformation(UserInformation usin) throws Exception {
		// TODO Auto-generated method stub
		baseDAO.add(usin);
	}

	@Override
	public void updateInformation(UserInformation usin) throws Exception {
		// TODO Auto-generated method stub
		baseDAO.update(usin);
	}

}
