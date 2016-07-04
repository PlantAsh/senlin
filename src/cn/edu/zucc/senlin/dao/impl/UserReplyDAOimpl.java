package cn.edu.zucc.senlin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.zucc.senlin.commondao.BaseDAOimpl;
import cn.edu.zucc.senlin.dao.UserReplyDAO;
import cn.edu.zucc.senlin.model.UserReply;

@Repository("userReplyDAO")
public class UserReplyDAOimpl extends BaseDAOimpl<UserReply> implements UserReplyDAO {

	@Override
	public List<UserReply> loadReply(UserReply userReply) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<UserReply> ur = new ArrayList<UserReply>();
			String hql = "from UserReply where replyLabel = '" + userReply.getReplyLabel() + "' ORDER BY replyDate DESC";
			ur = (List<UserReply>) findByHQL(hql);
			return ur;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

}
