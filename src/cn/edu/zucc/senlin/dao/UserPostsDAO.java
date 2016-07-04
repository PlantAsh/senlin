package cn.edu.zucc.senlin.dao;

import java.util.List;

import cn.edu.zucc.senlin.model.UserPosts;

public interface UserPostsDAO {
	public List<UserPosts> loadPosts(UserPosts userPosts, int first) throws Exception;
	
	public int getQuantity(UserPosts userPosts) throws Exception;
	
	public void addPosts(UserPosts userPosts) throws Exception;
	
	public List<UserPosts> getPosts(UserPosts userPosts) throws Exception;

}
