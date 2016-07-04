package cn.edu.zucc.senlin.service;

import java.util.List;

import cn.edu.zucc.senlin.model.UserPosts;

public interface PostsService {
	public List<UserPosts> loadPosts(UserPosts userPosts, int first) throws Exception;
	
	public int getQuantity(UserPosts userPosts) throws Exception;
	
	public String addPosts(UserPosts userPosts) throws Exception;
	
	public UserPosts getPosts(UserPosts userPosts) throws Exception;

}
