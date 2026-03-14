<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Q_ITOffer锐聘网后台管理系统</title>
<link href="${pageContext.request.contextPath}/admin/css/left.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath}/admin/js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>
</head>
<body style="background:#f0f9fd;">
<div class="lefttop"><span></span>功能菜单</div>
<dl class="leftmenu">
  <dd>
    <div class="title"> <span><img src="${pageContext.request.contextPath}/admin/images/leftico01.png" /></span>企业职位管理</div>
    <ul class="menuson">
      <li><cite></cite><a href="${pageContext.request.contextPath}/findJob" target="rightFrame">职位管理</a><i></i></li>
      <li><cite></cite><a href="${pageContext.request.contextPath}/findAllCompany" target="rightFrame">企业管理</a><i></i></li>
    </ul>
  </dd>
  <dd>
    <div class="title"> <span><img src="${pageContext.request.contextPath}/admin/images/leftico02.png" /></span>简历管理</div>
    <ul class="menuson">
      <li><cite></cite><a href="${pageContext.request.contextPath}/findresume" target="rightFrame">简历查询</a><i></i></li>
    </ul>
  </dd>
  <dd>
    <div class="title"><span><img src="${pageContext.request.contextPath}/admin/images/leftico03.png"/></span>用户管理</div>
  	<ul class="menuson">
      <li><cite></cite><a href="${pageContext.request.contextPath}/findApplyjob" target="rightFrame">求职管理</a><i></i></li>
      <li><cite></cite><a href="${pageContext.request.contextPath}/findAdmin" target="rightFrame">管理员用户管理</a><i></i></li>
    </ul>
  </dd>


</dl>
</body>
</html>
