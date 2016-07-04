<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="UTF-8">
<title>森林</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
<link rel="stylesheet" href="assets/css/amazeui.min.css" />
<style>
.header {
	text-align: center;
}

.header h1 {
	font-size: 200%;
	color: #333;
	margin-top: 30px;
}

.header p {
	font-size: 14px;
}
</style>

<script type="text/javascript">
		function ok() {
			var account = document.manage.userAccount;
			var password1 = document.manage.userPassword;
			var password2 = document.manage.userPassword2;
			if(account.value == "") {
				account.focus();
				account.placeholder = "账号不能为空";
				account.style.color = "Red";
			}else if(password1.value == "" || password1.value.length > 20) {
				password1.focus();
				password1.placeholder = "密码不符合规格";
				password1.style.color = "Red";
			}else if(password1.value != password2.value) {
				password2.focus();
				password2.placeholder = "两次密码不一致";
				password2.style.color = "Red";
				password1.style.color = "Red";
			}else {
				manage.action = "User_Regist.action "
				document.manage.submit();
			}
		}
		function cancel() {
			manage.action = "login.jsp"
			document.manage.submit();
		}
</script>
	
</head>
<body>

<div class="header">
  <div class="am-g">
    <h1>森林</h1>
    <p>The social network<br/>三三两两，悠然自得，上上下下，你来我往</p>
  </div>
  <hr />
</div>

<div class="am-g">
  <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">   
    
    <form action="" name="manage" method="post" class="am-form">
      <label for="userAccount">账号:</label>
      <input type="text" name="userBean.userAccount" id="userAccount" placeholder="请输入账号。" required/>
      <br>
      <label for="userPassword">密码:</label>
      <input type="password" name="userBean.userPassword" id="userPassword" placeholder="请输入1-20个字符的密码。" required/>
      <br>
      <label for="userPassword2">确认密码:</label>
      <input type="password" id="userPassword2" placeholder="请再输入一次密码。" required/>
      <br>
      <div class="am-cf">
        <input type="button" onclick="ok()" value="确 认" class="am-btn am-btn-primary am-btn-sm am-fl" style="float:left;"/>
        <input type="button" onclick="cancel()" value="取 消" class="am-btn am-btn-primary am-btn-sm am-fl"  style="float:left;margin-left:15px;"/>
      </div>
    </form>
    <hr>
    <p><%@ include file="Frame_bottom.jsp"%></p>
  </div>
</div>

</body>
</html>