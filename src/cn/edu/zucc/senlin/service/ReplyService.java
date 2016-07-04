package cn.edu.zucc.senlin.service;

import java.util.List;

import cn.edu.zucc.senlin.model.UserReply;

public interface ReplyService {
public List<UserReply> loadPosts(UserReply userReply) throws Exception;
	
	public String addPosts(UserReply userReply) throws Exception;

}
