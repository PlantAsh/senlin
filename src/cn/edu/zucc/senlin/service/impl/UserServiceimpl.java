package cn.edu.zucc.senlin.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zucc.senlin.dao.UserDAO;
import cn.edu.zucc.senlin.dao.UserInformationDAO;
import cn.edu.zucc.senlin.model.User;
import cn.edu.zucc.senlin.model.UserInformation;
import cn.edu.zucc.senlin.service.UserService;

@Service("userService")
public class UserServiceimpl implements UserService {
	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	@Resource(name="userInformationDAO")
	private UserInformationDAO userInformationDAO;

	@Override
	public String addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<User> us = null;
			us = userDAO.loadUser(user.getUserAccount());
			if (!us.isEmpty()) {
				ActionContext.getContext().getSession().put("error", "’À∫≈“—¥Ê‘⁄");
				return "error";
			}
			userDAO.addUser(user);
			UserInformation usin = new UserInformation();
			usin.setUserAccount(user.getUserAccount());
			usin.setUserName(user.getUserAccount());
			userInformationDAO.addInformation(usin);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ActionContext.getContext().getSession().put("error", "Œ¥÷™¥ÌŒÛ");
			return "error";
		}
	}

	@Override
	public User loadUser(User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<User> us = null;
			User us2 = new User();
			us = userDAO.loadUser(user.getUserAccount());
			if (us.isEmpty()) {
				ActionContext.getContext().getSession().put("error", "’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
				return null;
			}
			
			Iterator<User> iterator = us.iterator();
			us2 = iterator.next();
			if(!us2.getUserPassword().equals(user.getUserPassword())) {
				ActionContext.getContext().getSession().put("error", "’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
				us2.setUserID("error");
				return null;
			}else if(us2.getUserLevel() == 1) {
				return us2;
			}else {
				ActionContext.getContext().getSession().put("error", "’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
				us2.setUserID("error");
				return null;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public UserInformation getInformation(UserInformation usin) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<UserInformation> us = null;
			us = userInformationDAO.getInformation(usin.getUserAccount());
			UserInformation usin2 = new UserInformation();
			Iterator<UserInformation> iterator = us.iterator();
			usin2 = iterator.next();
			return usin2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public String updateInformation(UserInformation usin) throws Exception {
		try {
			List<UserInformation> us = null;
			us = userInformationDAO.getInformation(usin.getUserAccount());
			UserInformation usin2 = new UserInformation();
			Iterator<UserInformation> iterator = us.iterator();
			usin2 = iterator.next();
			usin.setInformationID(usin2.getInformationID());
			userInformationDAO.updateInformation(usin);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

}
