package cn.edu.zucc.senlin.dao;

import java.util.List;

import cn.edu.zucc.senlin.commondao.BaseDAO;
import cn.edu.zucc.senlin.model.UserReply;

public interface UserReplyDAO extends BaseDAO<UserReply> {
	public List<UserReply> loadReply(UserReply userReply) throws Exception;

}
