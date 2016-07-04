package cn.edu.zucc.senlin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.zucc.senlin.commondao.BaseDAOimpl;
import cn.edu.zucc.senlin.dao.UserInformationDAO;
import cn.edu.zucc.senlin.model.UserInformation;

@Repository("userInformationDAO")
public class UserInformationDAOimpl extends BaseDAOimpl<UserInformation> implements UserInformationDAO {

	@Override
	public List<UserInformation> getInformation(String userAccount) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<UserInformation> us = new ArrayList<UserInformation>();
			String hql = "from UserInformation where UserAccount = '" + userAccount + "'";
			us = (List<UserInformation>) findByHQL(hql);
			return us;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void updateInformation(UserInformation usin) throws Exception {
		// TODO Auto-generated method stub
        try {
        	usin = (UserInformation) this.getCurrent().merge(usin);
            update(usin);
        } catch (Exception e) {
            throw e;
        }
	}

}
