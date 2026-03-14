<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="utf-8">
<title>修改</title>
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
  <form name="frm" action="${pageContext.request.contextPath}/updateAdmin?adminId=${admin.adminId}" method="post">
    <div class="tabson">
      <ul class="forminfo">
        <%--<li>
          <label>编号<b>*</b></label>
          <input name="adminId" type="text" class="dfinput" style="width:518px;" value="${admin.adminId}" readonly = readonly/>
        </li>--%>
      	<li>
          <label>登录名称<b>*</b></label>
          <input name="adminLogin" type="text" class="dfinput" style="width:518px;" value="${admin.adminLogin}"/>
        </li>
        <li>
          <label>登录密码<b>*</b></label>
          <input name="adminPwd" type="password" class="dfinput" style="width:518px;" value="${admin.adminPwd}"/>
        </li>
        <li>
          <label>真实姓名<b>*</b></label>
          <input name="adminName" type="text" class="dfinput" style="width:518px;" value="${admin.adminName}"/>
        </li>
        <li>
          <label>邮箱<b>*</b></label>
          <input name="adminEmail" type="text" class="dfinput" style="width:518px;" value="${admin.adminEmail}"/>
        </li>
        <li>
          <label>用户角色<b>*</b></label>
          <div class="vocation">

            <select name="adminRole" class="select3">
              <c:if test="${admin.adminRole eq '普通用户'}">
                <option value="普通用户" selected="selected">普通用户</option>
                <option value="企业管理员">企业管理员</option>
                <option value="超管">超管</option>
              </c:if>
              <c:if test="${admin.adminRole eq '企业管理员'}">
                <option value="普通用户" >普通用户</option>
                <option value="企业管理员" selected="selected">企业管理员</option>
                <option value="超管">超管</option>
              </c:if>
              <c:if test="${admin.adminRole eq '超管'}">
                <option value="普通用户" >普通用户</option>
                <option value="企业管理员">企业管理员</option>
                <option value="超管" selected="selected">超管</option>
              </c:if>
            </select>

          </div>
        </li>
        <li>  <label>&nbsp;</label>
          <input name="" type="submit" class="btn" value="修改"/>
        </li>
      </ul>
    </div>
  </form>
    <font color="red">${saveError}</font>
  </div>
</div>
</body>
</html>