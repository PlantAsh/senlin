package cn.edu.zucc.senlin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.zucc.senlin.commondao.BaseDAO;
import cn.edu.zucc.senlin.dao.UserReplyDAO;
import cn.edu.zucc.senlin.model.UserReply;

@SuppressWarnings("unchecked")
@Repository("userReplyDAO")
public class UserReplyDAOimpl implements UserReplyDAO {
	@Resource(name="baseDAO")
	private BaseDAO baseDAO;

	@Override
	public List<UserReply> loadReply(UserReply userReply) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<UserReply> ur = new ArrayList<UserReply>();
			String hql = "from UserReply where replyLabel = '" + userReply.getReplyLabel() + "' ORDER BY replyDate DESC";
			ur = (List<UserReply>) baseDAO.findByHQL(hql);
			return ur;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void addReply(UserReply userReply) throws Exception {
		// TODO Auto-generated method stub
		baseDAO.add(userReply);
	}

}
