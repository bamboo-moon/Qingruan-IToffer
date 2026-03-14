<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="utf-8">
<title>注册 - 锐聘网</title>
<link href="${pageContext.request.contextPath}/user/css/base.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/user/css/register.css" type="text/css" rel="stylesheet" />
<meta content="大学生求职,大学生就业,大学生招聘,IT人才,IT人才招聘,大学生名企招聘,,大学生找工作,IT名企招聘，IT行业招聘，IT企业快速入职" name="keywords">
<meta content="锐聘专注于为企业提供高效的人力资源解决方案，同时面向IT类技术人才推出快速一站式免费就业服务。秉承QST青软实训人才服务理念，为数千家企业量身定做个性化、全程化的人才培养体系，同时帮助中高级人才铺设成功之路，为人才和企业架设起沟通之桥。" name="description">
<script>
  function changeCode(){
    var codeImg = document.getElementById("codeImg");
    codeImg.src="${pageContext.request.contextPath}/codePath?time="+new Date().getTime();
  }
</script>
</head>

<body>
<iframe src="${pageContext.request.contextPath}/user/top.jsp" width="100%" height="100"  scrolling="no" frameborder="0" ></iframe>
<div class="content">
  <div class="page_name">注册</div>
  <form action="${pageContext.request.contextPath}/regUser" method="post">
  <div class="login_content">
    <div class="login_l">
      <div class="span1">
        <label class="tn-form-label">账号：</label>
        <input  class="tn-textbox" name="userCode" type="text">
      </div>
      <div class="span1">
        <label class="tn-form-label">密码：</label>
        <input class="tn-textbox" name="userPwd"  type="password">
      </div>
      <div class="span1">
        <label class="tn-form-label">确认密码：</label>
        <input class="tn-textbox" name="userPwd1" type="password">
      </div>
      <div class="span1">
        <label class="tn-form-label">验证码：</label>
        <input class="tn-textbox-long" name="regValidateCode" type="text">
        <span> <img src="${pageContext.request.contextPath}/codePath" title="点击换一换" id="codeImg"> <a href="javascript:changeCode();" >看不清？</a> </span> </div>
      <div class="tn-form-row-button">
        <div class="span1">
          <font color="red">${regError}</font><br/>
          <input type="submit" class="tn-button-text" value="立即注册">
          <p class="it-register-text">
            <input  name="" id="" class="tn-checkbox" value="true" checked="checked" type="checkbox">
            <label > 同意本站服务条款</label>
            <a href="javascript:;">查看</a> </p>
        </div>
      </div>
      <div class="clear"></div>
    </div>
    <div class="register_r">
      <p align="center"> <b>已有账户</b><a  href="${pageContext.request.contextPath}/user/login.jsp">快速登录</a></p>
    
      <div><img src="${pageContext.request.contextPath}/user/images/reg_pic.jpg"></div>
    
      <div class="clear"></div>
    </div>
    <div class="clear"></div>
  </div>

  </form>
</div>
<iframe src="${pageContext.request.contextPath}/user/foot.jsp" width="100%" height="150"  scrolling="no" frameborder="0" ></iframe>
</body>
</html>
