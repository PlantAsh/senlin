<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="cn.edu.zucc.senlin.model.UserInformation"%>
<html class="no-js fixed-layout">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>森林</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="assets/css/admin.css">
  
</head>
<body>
<%@ include file="Frame_top.jsp"%>

<div class="am-cf admin-main">
  <%@ include file="Frame_left.jsp"%>

  <div class="admin-content">
    <div class="admin-content-body">

      <div class="am-g">
        <div class="am-u-sm-12 am-u-sm-centered">
          <h2><%=usin.getUserName() %></h2>
          <p><%=usin.getUserBirthday() %></p>
          <p><%=usin.getUserFloor() %></p>
          <p><%=usin.getUserMajor() %></p>
          <p><%=usin.getUserEmail() %></p>
          <p><%=usin.getUserTelephone() %></p>
          <hr/>
        </div>

        <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
          <h3>简介</h3>
          <p><%=usin.getUserIntro() %></p>
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
