package cn.edu.zucc.senlin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.zucc.senlin.commondao.BaseDAOimpl;
import cn.edu.zucc.senlin.dao.UserPostsDAO;
import cn.edu.zucc.senlin.model.UserPosts;

@Repository("userPostsDAO")
public class UserPostsDAOimpl extends BaseDAOimpl<UserPosts> implements UserPostsDAO {

	@Override
	public List<UserPosts> loadPosts(UserPosts userPosts, int first) throws Exception {
		try {
			List<UserPosts> up = new ArrayList<UserPosts>();
			String hql = "from UserPosts where postsFloor = '" + userPosts.getPostsFloor() + "' ORDER BY postsDate DESC";
			up = (List<UserPosts>) findByQuantity(hql, first, 15);
			return up;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<UserPosts> getPosts(UserPosts userPosts) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<UserPosts> up = new ArrayList<UserPosts>();
			String hql = "from UserPosts where postsID = '" + userPosts.getPostsID() + "'";
			up = (List<UserPosts>) findByHQL(hql);
			return up;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int getQuantity(UserPosts userPosts) throws Exception {
		try {
			int quantity;
			String hql = "select count(*) from UserPosts where postsFloor = '" + userPosts.getPostsFloor() + "' ORDER BY postsDate DESC";
			quantity = findQuantity(hql);
			return quantity;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

}
