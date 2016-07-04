package cn.edu.zucc.senlin.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.zucc.senlin.dao.UserPostsDAO;
import cn.edu.zucc.senlin.model.UserPosts;
import cn.edu.zucc.senlin.service.PostsService;

@Service("postsService")
public class PostsServiceimpl implements PostsService {
	@Resource(name="userPostsDAO")
	private UserPostsDAO userPostsDAO;

	@Override
	public List<UserPosts> loadPosts(UserPosts userPosts, int first) throws Exception {
		try {
			List<UserPosts> up = null;
			up = userPostsDAO.loadPosts(userPosts, first);
			return up;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	@Override
	public String addPosts(UserPosts userPosts) throws Exception {
		// TODO Auto-generated method stub
		try {
			userPostsDAO.add(userPosts);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	@Override
	public UserPosts getPosts(UserPosts userPosts) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<UserPosts> up = null;
			up = userPostsDAO.getPosts(userPosts);
			if(up.isEmpty()) {
				ActionContext.getContext().getSession().put("error", "Êý¾Ý¿â´íÎó");
				return null;
			}
			Iterator<UserPosts> iterator = up.iterator();
			UserPosts usp = new UserPosts();
			usp = iterator.next();
			return usp;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	@Override
	public int getQuantity(UserPosts userPosts) throws Exception {
		// TODO Auto-generated method stub
		try {
			int up;
			up = userPostsDAO.getQuantity(userPosts);
			return up;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

}
