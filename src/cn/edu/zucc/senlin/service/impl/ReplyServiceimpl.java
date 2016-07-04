package cn.edu.zucc.senlin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.zucc.senlin.dao.UserReplyDAO;
import cn.edu.zucc.senlin.model.UserReply;
import cn.edu.zucc.senlin.service.ReplyService;

@Service("replyService")
public class ReplyServiceimpl implements ReplyService {
	@Resource(name = "userReplyDAO")
	private UserReplyDAO userReplyDAO;

	@Override
	public List<UserReply> loadPosts(UserReply userReply) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<UserReply> ur = null;
			ur = userReplyDAO.loadReply(userReply);
			return ur;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	@Override
	public String addPosts(UserReply userReply) throws Exception {
		// TODO Auto-generated method stub
		try {
			userReplyDAO.add(userReply);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

}
