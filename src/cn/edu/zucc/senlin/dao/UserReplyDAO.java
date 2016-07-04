package cn.edu.zucc.senlin.dao;

import java.util.List;

import cn.edu.zucc.senlin.model.UserReply;

public interface UserReplyDAO {
	public List<UserReply> loadReply(UserReply userReply) throws Exception;
	
	public void addReply(UserReply userReply) throws Exception;

}
