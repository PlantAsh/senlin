package cn.edu.zucc.senlin.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zucc.senlin.model.User;
import cn.edu.zucc.senlin.model.UserInformation;
import cn.edu.zucc.senlin.service.UserService;

@Results({@Result(name = "login", location = "/login.jsp"),
	@Result(name = "regist", location = "/regist.jsp"),
	@Result(name = "information", location = "/UserInformation.jsp"),
	@Result(name = "level1", location = "/UserLevel1.jsp")})
public class UserManage extends ActionSupport  implements ServletResponseAware {
	private static final long serialVersionUID = -2266695172069461659L;
	@Resource(name="userService")
	public UserService userService;
	
	private javax.servlet.http.HttpServletResponse response;
	
	private User userBean;
	private UserInformation userinBean;
	
	@Action(value = "User_Login")
	public String Login() throws Exception {
		response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
		
		try {
			User user = new User();
			user = this.getUserBean();
			User us = userService.loadUser(user);
			
			if(us == null) {
				out.print("<script>alert('" + ActionContext.getContext().getSession().get("error") + "')</script>");
				out.flush();
				return "login";
			}else {
				String level = "level" + us.getUserLevel();
				ActionContext.getContext().getSession().put("UserAccount", us.getUserAccount());
				UserInformation usin = new UserInformation();
				usin.setUserAccount(us.getUserAccount());
				UserInformation usin2 = userService.getInformation(usin);
				ActionContext.getContext().getSession().put("userInformation", usin2);
				return level;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "login";
	}
	
	@Action(value = "User_Regist")
	public String Regist() throws Exception {
		response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
		
		try {
			User user = new User();
			user = this.getUserBean();
			user.setUserLevel(1);
			String us = userService.addUser(user);
			
			if (us.equals("error")) {
				out.print("<script>alert('" + ActionContext.getContext().getSession().get("error") + "')</script>");
				out.flush();
				return "regist";
			}else if(us.equals("success")){
				return "login";
			}
			return "regist";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "regist";
		}
	}
	
	@Action(value = "User_Cancel")
	public String Cancel() throws Exception {
		try {
			ActionContext.getContext().getSession().clear();
			return "login";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "login";
		}
	}

	@Action(value = "User_updateInformation")
	public String updateInformation() throws Exception {
		response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
		try {
			UserInformation usin = new UserInformation();
			usin = this.getUserinBean();
			String userAccount = (String) ActionContext.getContext().getSession().get("UserAccount");
			usin.setUserAccount(userAccount);
			String usin2 = userService.updateInformation(usin);
			if(usin2.equals("error")) {
				out.print("<script>alert('" + ActionContext.getContext().getSession().get("error") + "')</script>");
				out.flush();
				return "information";
			}
			ActionContext.getContext().getSession().put("userInformation", usin);
			return "level1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "information";
		}
	}
	
	/*-------------------------------------------------------------------------------------------------------------
	 * -----------------------------------------------------------------------------------------------------------*/
	
	public User getUserBean() {
		return userBean;
	}
	public void setUserBean(User userBean) {
		this.userBean = userBean;
	}
	
	public UserInformation getUserinBean() {
		return userinBean;
	}
	public void setUserinBean(UserInformation userinBean) {
		this.userinBean = userinBean;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

}
