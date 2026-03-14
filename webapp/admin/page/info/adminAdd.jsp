<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="utf-8">
<title>添加用户</title>
<link href="${pageContext.request.contextPath}/admin/css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="${pageContext.request.contextPath}/admin/page/main/index.jsp">首页</a></li>
    <li><a href="#">添加用户</a></li>
  </ul>
</div>
<div class="formbody">
  <div class="usual">
  <form name="frm" action="${pageContext.request.contextPath}/saveAdmin" method="post">
    <div class="tabson">
      <ul class="forminfo">
      	<li>
          <label>登录名称<b>*</b></label>
          <input name="adminLogin" type="text" class="dfinput" style="width:518px;"/>
        </li>
        <li>
          <label>登录密码<b>*</b></label>
          <input name="adminPwd" type="password" class="dfinput" style="width:518px;"/>
        </li>
        <li>
          <label>真实姓名<b>*</b></label>
          <input name="adminName" type="text" class="dfinput" style="width:518px;"/>
        </li>
        <li>
          <label>邮箱<b>*</b></label>
          <input name="adminEmail" type="text" class="dfinput" style="width:518px;"/>
        </li>
        <li>
          <label>用户角色<b>*</b></label>
          <div class="vocation">
            <select name="adminRole" class="select3">
              <option value="普通用户">普通用户</option>
              <option value="企业管理员">企业管理员</option>
              <option value="超管">超管</option>
            </select>
          </div>
        </li>
        <li>
          <label>用户状态<b>*</b></label>
          <input name="adminStatus" type="radio" value="0" checked="checked"/>启用
          <input name="adminStatus" type="radio" value="1"/>禁用
        </li>
        <li>  <label>&nbsp;</label>
          <input name="" type="submit" class="btn" value="添加"/>
        </li>
      </ul>
    </div>
  </form>
    <font color="red">${saveError}</font>
  </div>
</div>
</body>
</html>