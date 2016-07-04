package cn.edu.zucc.senlin.action;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zucc.senlin.model.UserInformation;
import cn.edu.zucc.senlin.model.UserPosts;
import cn.edu.zucc.senlin.model.UserReply;
import cn.edu.zucc.senlin.service.PostsService;
import cn.edu.zucc.senlin.service.ReplyService;

@Results({
	@Result(name = "floor", location = "/Floor.jsp"),
	@Result(name = "userPosts", location = "/UserPosts.jsp") })
public class PostsManage extends ActionSupport  implements ServletResponseAware {
	private static final long serialVersionUID = -2266695172069461659L;
	
	@Resource(name="postsService")
	private PostsService postsService;
	
	@Resource(name="replyService")
	private ReplyService replyService;
	
	private HttpServletResponse response;
	
	private UserPosts postsBean;
	private UserReply replyBean;
	
	private int first;
	private int quantity;
	
	@Action(value = "Floor", results = {
			@Result(name = "level1", location = "/UserLevel1.jsp")})
	public String Floor() throws Exception {
		try {
			first = 0;
			
			List<UserPosts> up = null;
			UserPosts usp = new UserPosts();
			usp = this.getPostsBean();
			ActionContext.getContext().getSession().put("postsFloor", usp.getPostsFloor());
			up = postsService.loadPosts(usp, first);
//			quantity = postsService.getQuantity(usp);
			
//			ActionContext.getContext().getSession().put("quantity", quantity/15);
			ActionContext.getContext().getSession().put("Floor", up);
			return "floor";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "level1";
		}
	}
	
	public String nextFloor() throws Exception {
		try {
			if(first > quantity) {
				return "floor";
			} else {
				first = first + 15;
				ActionContext.getContext().getSession().put("number", first/15+1);
				UserPosts usp = new UserPosts();
				String postsFloor = (String) ActionContext.getContext().getSession().get("postsFloor");
				usp.setPostsFloor(postsFloor);
				List<UserPosts> up = null;
	        	up = postsService.loadPosts(usp, first);
				ActionContext.getContext().getSession().put("Floor", up);
				return "floor";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "floor";
		}
	}
	
	public String backFloor() throws Exception {
		try {
			if(first < 15) {
				return "floor";
			} else {
				first = first - 15;
				ActionContext.getContext().getSession().put("number", first/15+1);
				UserPosts usp = new UserPosts();
				String postsFloor = (String) ActionContext.getContext().getSession().get("postsFloor");
				usp.setPostsFloor(postsFloor);
				List<UserPosts> up = null;
	        	up = postsService.loadPosts(usp, first);
				ActionContext.getContext().getSession().put("Floor", up);
				return "floor";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "floor";
		}
	}
	
	@Action(value = "Posts_addPosts", results = {
			@Result(name = "posts", location = "/Posts.jsp")})
	public String addPosts() throws Exception {
		response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
		try {
			UserPosts usp = new UserPosts();
			usp = this.getPostsBean();
			String postsFloor = (String) ActionContext.getContext().getSession().get("postsFloor");
			usp.setPostsFloor(postsFloor);
			UserInformation usin = (UserInformation) ActionContext.getContext().getSession().get("userInformation");
			usp.setUserAccount(usin.getUserAccount());
			usp.setUserName(usin.getUserName());
			Date date=new Date();
            usp.setPostsDate(date);
            String text = usp.getPostsText();
            text = text.replace("\r\n", "<br/>");
            usp.setPostsText(text);
            
            String p = postsService.addPosts(usp);
            if(p.equals("success")) {
            	first = 0;
            	List<UserPosts> up = null;
            	up = postsService.loadPosts(usp, first);
//            	quantity = postsService.getQuantity(usp);
    			
//    			ActionContext.getContext().getSession().put("quantity", quantity/15);
    			ActionContext.getContext().getSession().put("Floor", up);
            	return "floor";
            } else {
            	out.print("<script>alert('" + ActionContext.getContext().getSession().get("error") + "')</script>");
				out.flush();
				return "posts";
            }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "posts";
		}
	}

	@Action(value = "Posts_getPosts")
	public String getPosts() throws Exception {
		response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
		try {
			UserPosts usp = new UserPosts();
			usp = this.getPostsBean();
			UserPosts usp2 = new UserPosts();
			List<UserReply> ur = null;
			UserReply ur2 = new UserReply();
			ur2.setReplyLabel(usp.getPostsID());
			
			usp2 = postsService.getPosts(usp);
			ur = replyService.loadPosts(ur2);
			if(usp2 == null) {
				out.print("<script>alert('" + ActionContext.getContext().getSession().get("error") + "')</script>");
				out.flush();
				return "floor";
			} else {
				ActionContext.getContext().getSession().put("userPosts", usp2);
				ActionContext.getContext().getSession().put("userReply", ur);
				return "userPosts";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "floor";
		}
	}
	
	@Action(value = "Posts_Reply")
	public String replyPosts() throws Exception {
		response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
		try {
			UserReply ur = new UserReply();
			ur = this.getReplyBean();
			UserInformation usin = (UserInformation) ActionContext.getContext().getSession().get("userInformation");
			ur.setUserAccount(usin.getUserAccount());
			ur.setUserName(usin.getUserName());
			Date date=new Date();
			ur.setReplyDate(date);
			String text = ur.getReplyText();
            text = text.replace("\r\n", "<br/>");
            ur.setReplyText(text);
            UserPosts usp = (UserPosts) ActionContext.getContext().getSession().get("userPosts");
            ur.setReplyLabel(usp.getPostsID());
			
			String a = replyService.addPosts(ur);
			if(a.equals("success")) {
				List<UserReply> ur2 = null;
				ur2 = replyService.loadPosts(ur);
				ActionContext.getContext().getSession().put("userReply", ur2);
				return "userPosts";
			} else {
				out.print("<script>alert('" + ActionContext.getContext().getSession().get("error") + "')</script>");
				out.flush();
				return "userPosts";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "userPosts";
		}
	}

	/*-------------------------------------------------------------------------------------------------------------
	 * -----------------------------------------------------------------------------------------------------------*/
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	public UserPosts getPostsBean() {
		return postsBean;
	}
	public void setPostsBean(UserPosts postsBean) {
		this.postsBean = postsBean;
	}

	public UserReply getReplyBean() {
		return replyBean;
	}
	public void setReplyBean(UserReply replyBean) {
		this.replyBean = replyBean;
	}

}
