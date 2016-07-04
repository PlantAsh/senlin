<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
function OK() {
	var postsTitle = document.Post.postsTitle;
	var postsText = document.Post.postsText;
	if(postsTitle.value == "" || postsTitle.value.length > 50) {
		postsTitle.focus();
		alert("标题要在1-50字符内。");
	}else if(postsText.value == "" || postsText.value.length > 500) {
		postsText.focus();
		alert("内容要在1-500字符内。");
	}else {
		Post.action = "Posts_addPosts.action";
		document.Post.submit();
	}
}
function Cancel() {
	Post.action = "Floor.jsp"
	document.Post.submit();
}
</script>
</head>

<body>
<%@ include file="Frame_top.jsp"%>

<div class="am-cf admin-main">
  <%@ include file="Frame_left.jsp"%>
  
  <div class="admin-content">
    <div class="admin-content-body">

      <hr/>
      
      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
        </div>
      
        <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
          <form action="" name="Post" class="am-form am-form-horizontal">
            <div class="am-form-group">
              <label for="postsTitle" class="am-u-sm-3 am-form-label">标题 / Title</label>
              <div class="am-u-sm-9">
                <input type="text" name="postsBean.postsTitle" id="postsTitle"/>
              </div>
            </div>

            <div class="am-form-group">
              <label for="postsText" class="am-u-sm-3 am-form-label">内容 / Content</label>
              <div class="am-u-sm-9">
                <textarea class="" rows="5" name="postsBean.postsText" id="postsText"></textarea>
              </div>
            </div>

            <div class="am-form-group">
              <div class="am-u-sm-9 am-u-sm-push-3">
                <button type="button" onclick="OK()" class="am-btn am-btn-primary">发布</button>
                <button type="button" onclick="Cancel()" class="am-btn am-btn-primary">取消</button>
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