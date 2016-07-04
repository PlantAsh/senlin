package cn.edu.zucc.senlin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_posts")
public class UserPosts {
	private int postsID;
	private String userAccount;
	private String userName;
	private Date postsDate;
	private String postsTitle;
	private String postsText;
	private String postsFloor;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PostsID")
	public int getPostsID() {
		return postsID;
	}
	public void setPostsID(int postsID) {
		this.postsID = postsID;
	}
	
	@Column(name = "UserAccount")
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	
	@Column(name = "UserName")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "PostsDate")
	public Date getPostsDate() {
		return postsDate;
	}
	public void setPostsDate(Date postsDate) {
		this.postsDate = postsDate;
	}
	
	@Column(name = "PostsTitle")
	public String getPostsTitle() {
		return postsTitle;
	}
	public void setPostsTitle(String postsTitle) {
		this.postsTitle = postsTitle;
	}
	
	@Column(name = "PostsText")
	public String getPostsText() {
		return postsText;
	}
	public void setPostsText(String postsText) {
		this.postsText = postsText;
	}
	
	@Column(name = "PostsFloor")
	public String getPostsFloor() {
		return postsFloor;
	}
	public void setPostsFloor(String postsFloor) {
		this.postsFloor = postsFloor;
	}

}
