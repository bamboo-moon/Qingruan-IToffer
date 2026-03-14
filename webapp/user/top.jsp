<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
<meta charset="utf-8">
<title>无标题文档</title>
<link href="css/base.css" rel="stylesheet" type="text/css">
</head>

<body><div class="head">
	<div class="head_area">
		<div class="head_nav">
			<ul>

				<li>
					<a href="${pageContext.request.contextPath}/indexUser" target="_parent">
					<img src="${pageContext.request.contextPath}/user/images/nav_inc1.png" />
						首页</a>
				</li>
			</ul>
		</div>
		<div class="head_logo"><img src="${pageContext.request.contextPath}/user/images/head_logo.png" /></div>
		<div class="head_user">
		<c:if test="${user==null}">
			<a href="${pageContext.request.contextPath}/user/login.jsp" target="_parent"><span class="type1">登录</span></a>
			<a href="${pageContext.request.contextPath}/user/register.jsp" target="_parent"><span class="type2">注册</span></a>
		</c:if>
			<c:if test="${user!=null}">
			<a href="${pageContext.request.contextPath}/findUserById" target="_parent">${user.userCode}</a>
			<a href="${pageContext.request.contextPath}/loginOut" target="_parent">退出</a>
		</c:if>
		</div>
		<div class="clear"></div>
	</div>
</div>

<div class="top_main">
	<div class="top_logo"><img src="${pageContext.request.contextPath}/user/images/main_logo.png" /></div>
	<div class="top_instr">提供岗前培训的IT职位</div>
	<div class="top_tel"><img src="${pageContext.request.contextPath}/user/images/it-phone.png" /></div>
	<div class="clear"></div>
</div>

<div class="clear"></div>

</body>
</html>
