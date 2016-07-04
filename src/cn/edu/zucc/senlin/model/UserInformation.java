package cn.edu.zucc.senlin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user_information")
public class UserInformation {
	private int informationID;
	private String userAccount;
	private String userName;
	private String userFloor;//Â¥
	private String userMajor;//×¨Òµ
	private String userIntro;//¼ò½é
	private String userEmail;
	private String userTelephone;
	private String userBirthday;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InformationID")
	public int getInformationID() {
		return informationID;
	}
	public void setInformationID(int informationID) {
		this.informationID = informationID;
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
	
	@Column(name = "UserFloor")
	public String getUserFloor() {
		return userFloor;
	}
	public void setUserFloor(String userFloor) {
		this.userFloor = userFloor;
	}
	
	@Column(name = "UserMajor")
	public String getUserMajor() {
		return userMajor;
	}
	public void setUserMajor(String userMajor) {
		this.userMajor = userMajor;
	}
	
	@Column(name = "UserIntro")
	public String getUserIntro() {
		return userIntro;
	}
	public void setUserIntro(String userIntro) {
		this.userIntro = userIntro;
	}
	
	@Column(name = "UserEmail")
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	@Column(name = "UserTelephone")
	public String getUserTelephone() {
		return userTelephone;
	}
	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}
	
	@Column(name = "UserBirthday")
	public String getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	
}
