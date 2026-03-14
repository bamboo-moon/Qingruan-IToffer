<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
<style>
body {
	font: 12px/30px microsoft yahei;
	background: #053364;
}
.login_content {
	background: url(${pageContext.request.contextPath}/admin/images/login.png) no-repeat;
	width: 737px;
	height: 396px;
	margin: 150px auto 0px;
}

.login_name {
	float: left;
	margin: 50px 0px 0px 400px;
	color: black;
	font-size: 14px;
	line-height: 35px;
}

.login_name h3 {
	font-size: 16px;
	border-bottom: 1px dotted #02356f;
}

.login_input {
	padding: 5px;
	height: 20px;
	line-height: 20px;
	color: gray;
	width: 200px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
}

.yzm_input {
	width: 100px;
	padding: 5px;
	height: 20px;
	line-height: 20px;
	color: gray;
	border: 1px solid #ccc;
	margin-right: 5px;
}
.login_button{background:#008ffd;border-radius:5px;width:80px;height:35px;line-heihgt:35px;display:block; margin-top:10px; color:white; border:none; font-family:microsoft yahei;cursor:pointer;}
.login_button:hover{ background:#00b8e6;color:yellow; }
</style>
<script type="text/javascript">
	// 表单提交请求验证
	function validate() {
		if(document.getElementById("userLogname").value == ""){
			alert("用户登录名不能为空！");
			document.getElementById("userLogname").focus();
			return false;
		}
		if(document.getElementById("userPwd").value == ""){
			alert("登录密码不能为空！");
			document.getElementById("userPwd").focus();
			return false;
		}
		if(document.getElementById("validateCode").value == ""){
			alert("验证码不能为空！");
			document.getElementById("validateCode").focus();
			return false;
		}
		return true;
	}
	function changeCode(){
		//发起请求  获取新的图片  并把图片赋值给img的src
		var imgCode = document.getElementById("codeImg");
		imgCode.src="${pageContext.request.contextPath}/codePath?time="+new Date().getTime();
	}
</script>
</head>
<body>
	<div class="login_content">
		<div class="login_name">
			<h3>用户登录</h3>
			<form action="${pageContext.request.contextPath}/loginAdmin" method="post" onsubmit="return validate();">
				<div>
					用户名：<input name="adminLogin" id="userLogname" type="text"
						class="login_input" />
				</div>
				<div>
					密&nbsp;&nbsp;&nbsp;&nbsp;码：<input name="adminPwd" id="userPwd"
						type="password" class="login_input" />
				</div>
				<div>
					验证码：<input name="checkCode" id="validateCode" type="text"
						class="yzm_input" />
						<a href="javascript:changeCode();">
						<img src="${pageContext.request.contextPath}/codePath" id="codeImg"></a>
				</div>
				<div align="center">
					<input type="submit" class="login_button" value="登&nbsp;&nbsp;录"></input>
				</div>
			</form>
			<font color="red">${loginError}</font>
		</div>
	</div>
</body>
</html>
