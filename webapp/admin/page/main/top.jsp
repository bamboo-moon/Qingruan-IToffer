<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="utf-8">
<title>Q_ITOffer锐聘网后台管理系统</title>
<link href="${pageContext.request.contextPath}/admin/css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body style="background:url(${pageContext.request.contextPath}/admin/images/topbg.gif) repeat-x;">
<div class="topleft"> 
<a href="main.html" target="_parent"><img src="${pageContext.request.contextPath}/admin/images/main_logo.png" title="系统首页" /></a> </div>

<div class="topright">
  <ul>
    <li><span><img src="${pageContext.request.contextPath}/admin/images/help.png" title="帮助" class="helpimg"/></span><a href="javascript:void(0)">没有帮助</a></li>
    <li><a href="javascript:void(0)">没有关于</a></li>
    <li><a href="${pageContext.request.contextPath}/adminloginOut" target="_parent">退出</a></li>
  </ul>
  <div class="user"><span>${admin.adminName}</span></div>
</div>
<ul class="nav">
  <li><a href="${pageContext.request.contextPath}/indexUser" target="_blank" class="selected"><img src="${pageContext.request.contextPath}/admin/images/globe.png" title="网站前台" />
    <h2>网站前台</h2>
    </a></li>
  <li><a href="${pageContext.request.contextPath}/admin/page/main/index.jsp" target="rightFrame"><img src="${pageContext.request.contextPath}/admin/images/home.png" title="后台首页" />
    <h2>后台首页</h2>
    </a></li>
</ul>
</body>
</html>
