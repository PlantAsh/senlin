<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%@ page import="cn.edu.zucc.senlin.model.UserPosts"%>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>森林</title>
  <meta name="description" content="这是一个 table 页面">
  <meta name="keywords" content="table">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="assets/css/admin.css">
</head>

<script type="text/javascript">
function post() {
	posts.action = "Posts.jsp";
	document.posts.submit();
}
</script>
<body>
<%@ include file="Frame_top.jsp"%>

<div class="am-cf admin-main">
  <%@ include file="Frame_left.jsp"%>
  
  <div class="admin-content">
    <div class="admin-content-body">
      
      <hr/>
      
      <form action="" name="posts">
      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-3">
          <div class="am-input-group am-input-group-sm">
          <span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="button" onclick="post()">发帖</button>
          </span>
          </div>
        </div>
      </div>
      </form>

      <div class="am-g">
        <div class="am-u-sm-12">
          <form class="am-form">
            <table class="am-table am-table-striped am-table-hover table-main">
              <thead>
              <tr>
                <th class="table-title">标题</th><th class="table-author am-hide-sm-only">作者</th><th class="table-date am-hide-sm-only">发布时间</th>
              </tr>
              </thead>
              
              <%
              List up=(List) session.getAttribute("Floor");
              if(up.isEmpty()) { 
              %>
            	  <tbody>
                  <tr>
                    <td class="am-hide-sm-only">你将是第一个</td>
                    <td class="am-hide-sm-only">你将是第一个</td>
                    <td class="am-hide-sm-only">你将是第一个</td>
                  </tr>
                  </tbody>
              <%
              } else {
              for(int i=0; i<up.size(); i++) {
            	  UserPosts usp = (UserPosts) up.get(i);
              %>
              <tbody>
              <tr>
                <td><a href="Posts_getPosts?postsBean.postsID=<%=usp.getPostsID() %>"><%=usp.getPostsTitle() %></a></td>
                <td class="am-hide-sm-only"><%=usp.getUserName() %></td>
                <td class="am-hide-sm-only"><%=usp.getPostsDate() %></td>
              </tr>
              </tbody>
              <%
              }
              }
              %>
            </table>
            
            <!-- <div class="am-cf">
              <div class="am-fr">
              <ul class="am-pagination">
              <li class="am-disabled"><a href="#">«</a></li> -->
              <%-- <%
              int quantity = Integer.valueOf(session.getAttribute("quantity").toString());
              int number = Integer.valueOf(session.getAttribute("number").toString());
              for(int i=0; i<quantity; i++) {
            	  if(i+1 == number) {
              %> --%>
              <!-- <li class="am-active">i+1</li> -->
              <%-- <%
            	  } else {
              %> --%>
              <!-- <li>i+1</li> -->
              <%-- <%  
            	  }
              }
              %> --%>
                 <!--  <li><a href="#">»</a></li>
                </ul>
              </div>
            </div> -->
            <%-- <%
              }
            %> --%>
            <hr />
          </form>
        </div>

      </div>
    </div>

    <footer class="admin-content-footer">
      <hr>
      <p class="am-padding-left"><%@ include file="Frame_bottom.jsp"%></p>
    </footer>

  </div>
  <!-- content end -->
</div>

<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>


<script src="assets/js/jquery.min.js"></script>

<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
</body>
</html>