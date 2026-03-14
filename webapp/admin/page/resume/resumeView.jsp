<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="utf-8">
<title>简历详情</title>
<link href="${pageContext.request.contextPath}/admin/css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="${pageContext.request.contextPath}/admin/page/main/index.jsp">首页</a></li>
    <li><a href="${pageContext.request.contextPath}/findresume">简历列表</a></li>
    <li>简历详情</li>
  </ul>
</div>
<div class="formbody">
  <div class="usual">
    <div class="tabson">
      <ul class="forminfo">


      	<li>
          <label>真实姓名：</label><label style="width: 200px;"><b style="color: #000">${user.userName}</b></label>
        </li>
        <li>
          <label>照片：</label>
          <img src="${pageContext.request.contextPath}/upload/${user.userImg}" width="120px" height="120px">
        </li>
        <li>
          <label>性别：</label><label style="width: 200px;"><b style="color: #000">${user.userSex}</b></label>
        </li>
        <li>
          <label>出生日期：</label><label style="width: 200px;"><b style="color: #000">${user.userBirthday}</b></label>
        </li>
        <li>
          <label>手机号：</label><label style="width: 200px;"><b style="color: #000">${user.userPhone}</b></label>
        </li>
        <li>
          <label>邮箱：</label><label style="width: 200px;"><b style="color: #000">${user.userEmail}</b></label>
        </li>
        <li>
          <label>求职意向：</label><label style="width: 200px;"><b style="color: #000">${user.userWork}</b></label>
        </li>
        <li>
          <label>工作经验：</label><label style="width: 200px;"><b style="color: #000">${user.userYear}</b></label>
        </li>


      </ul>
    </div>
  </div>
</div>
</body>
</html>
