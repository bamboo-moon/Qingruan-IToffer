<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="utf-8">
<title>企业列表</title>
<link href="${pageContext.request.contextPath}/admin/css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="${pageContext.request.contextPath}/admin/page/main/index.jsp">首页</a></li>
    <li><a href="#">企业列表</a></li>
  </ul>
</div>
<div class="rightinfo">
  <div class="tools">
    <ul class="toolbar">
      <li class="click"><span><img src="${pageContext.request.contextPath}/admin/images/t01.png" /></span><a href="${pageContext.request.contextPath}/admin/page/company/companyAdd.jsp">添加</a></li>
    </ul>
  </div>
  <table class="imgtable">
    <thead>
      <tr>
        <th ><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>企业名称</th>
        <th>企业所在地</th>
        <th>企业规模</th>
        <th>企业性质</th>
        <th>招聘状态</th>

        <th>图片</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${companyList}" var="company">
      <tr height="50px">
        <td ><input name="" type="checkbox" value="" /></td>
        <td>${company.companyName}</td>
        <td>${company.companyLoc}</td>
        <td>${company.companySize}</td>
        <td>${company.companyType}</td>
        <td>${company.companyStatus}</td>
        <td><img src="${pageContext.request.contextPath}/upload/${company.companyImg}" width="150px" height="50px"></td>
        <td ><a href="${pageContext.request.contextPath}/updatecompanyfirst?com_id=${company.companyId}" class="tablelink">修改</a> &nbsp;&nbsp;
          <a href="${pageContext.request.contextPath}/toAddJob?companyId=${company.companyId}" class="tablelink"> 发布职位</a>
        </td>
      </tr>
    </c:forEach>

    </tbody>
  </table>

</div>
</body>
</html>
