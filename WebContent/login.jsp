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
		function login() {
			var account = document.manage.userAccount;
			var password = document.manage.userPassword;
			if(account.value == "") {
				account.focus();
				account.placeholder = "账号不能为空";
				account.style.color = "Red";
			}else if(password.value == "" || password.value.length > 20) {
				password.focus();
				password.placeholder = "密码不符合规格";
				password.style.color = "Red";
			}else {
				manage.action = "User_Login.action";
				document.manage.submit();
			}
		}
		function regist() {
			manage.action = "regist.jsp";
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
      <input type="password" name="userBean.userPassword" id="userPassword" placeholder="请输入密码。" required/>
      <br>
      <label for="remember-me">
        <input id="remember-me" type="checkbox">
                记住密码
      </label>
      <br />
      <div class="am-cf">
        <input type="button" onclick="login()" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl" style="float:left;"/>
        <input type="button" onclick="regist()" value="注 册" class="am-btn am-btn-primary am-btn-sm am-fl"  style="float:left;margin-left:15px;"/>
        <input type="button" onclick="" value="忘记密码 " class="am-btn am-btn-default am-btn-sm am-fr"/>
      </div>
    </form>
    <hr>
    <p><%@ include file="Frame_bottom.jsp"%></p>
  </div>
</div>

</body>
</html>