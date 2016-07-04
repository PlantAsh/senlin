<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="cn.edu.zucc.senlin.model.UserPosts"%>
<%@ page import="cn.edu.zucc.senlin.model.UserReply"%>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>森林</title>
  <meta name="description" content="这是一个form页面">
  <meta name="keywords" content="form">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="assets/css/admin.css">
  
  <script type="text/javascript">
  function cancle() {
	  posts.action = "Floor.jsp";
	  document.posts.submit();
  }
  function Reply() {
	  var replyText = document.Post.replyText;
	  if(replyText.value == "" || replyText.value.length > 100) {
		  replyText.focus();
		  alert("回复内容在1-100字符内。");
	  }else {
		  Post.action = "Posts_Reply.action";
		  document.Post.submit();
	  }
  }
  </script>
</head>
<body>
<%@ include file="Frame_top.jsp"%>

<div class="am-cf admin-main">
  <%@ include file="Frame_left.jsp"%>
  
  <%
  UserPosts usp = (UserPosts) session.getAttribute("userPosts");
  %>
  
  <div class="admin-content">
    <div class="admin-content-body">
      <form action="" name="posts">
      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-3">
          <div class="am-input-group am-input-group-sm">
          <span class="am-input-group-btn">
            <button class="am-btn am-btn-primary" type="button" onclick="cancle()">返回</button>
          </span>
          </div>
        </div>
      </div>
      </form>
      
      <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg"><%=usp.getUserName() %></strong> <small>于<%=usp.getPostsDate() %>发帖</small></div>
      </div>
      
      <hr/>
      
      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
        </div>
      
        <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
          <form action="" name="Post" class="am-form am-form-horizontal">
            <div class="am-form-group">
              <div class="am-u-sm-9">
                <strong><font size="10"><%=usp.getPostsTitle() %></font></strong>
              </div>
            </div>

            <div class="am-form-group">
              <div class="am-u-sm-9">
                <small><font size="5"><%=usp.getPostsText() %></font></small>
              </div>
            </div>
      
            <hr/>
            
            <%
            List ur=(List) session.getAttribute("userReply");
            if(!ur.isEmpty()) { 
          	  for(int i=0; i<ur.size(); i++) {
          		  UserReply ur2 = (UserReply) ur.get(i);
            %>
            <div class="am-cf am-padding am-padding-bottom-0">
              <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg"><%=ur2.getUserName() %></strong> <small>  <%=ur2.getReplyDate() %></small></div>
            </div>
            <div class="am-form-group">
              <div class="am-u-sm-9">
                <small><font size="5"><%=ur2.getReplyText() %></font></small>
              </div>
            </div>
            <hr/>
            <%
          	  }
            }
            %>
            
            <div class="am-form-group">
              <div class="am-u-sm-9">
                <textarea class="" rows="5" name="replyBean.replyText" id="replyText"></textarea>
              </div>
            </div>
            
            <div class="am-form-group">
              <div class="am-u-sm-9 am-u-sm-push-3">
                <button class="am-btn am-btn-primary" type="button" onclick="Reply()">回帖</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>

    <footer class="admin-content-footer">
      <hr>
      <p class="am-padding-left"><%@ include file="Frame_bottom.jsp"%></p>
    </footer>

  </div>

</div>

<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>



<script src="assets/js/jquery.min.js"></script>

<script src="assets/js/amazeui.min.js"></script>

<script src="assets/js/app.js"></script>
</body>
</html>