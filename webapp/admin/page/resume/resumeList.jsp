<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="utf-8">
<title>简历列表</title>
<link href="${pageContext.request.contextPath}/admin/css/manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="${pageContext.request.contextPath}/admin/page/main/index.jsp">首页</a></li>
    <li>简历列表</li>
  </ul>
</div>
<div class="rightinfo">
  <table class="imgtable">
    <thead>
      <tr>
        <th ><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>姓名</th>
        <th>手机</th>
        <th>Email</th>
        <th>工作经验</th>
        <th>求职意向</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
<c:forEach items="${users}" var="user">
  <c:if test="${not empty user.userName}">

  <tr height="50px">
    <td ><input name="" type="checkbox" value="" /></td>
    <td>${user.userName}</td>
    <td>${user.userPhone}</td>
    <td>${user.userEmail}</td>
    <td>${user.userYear}</td>
    <td>${user.userWork}</td>
    <td ><a href="${pageContext.request.contextPath}/watchresume?user_id=${user.userId}" class="tablelink">查看</a>
    </td>
  </tr>

  </c:if>
</c:forEach>


    </tbody>
  </table>

</div>
</body>
</html>

<%--
<div class="tools">
  <ul class="seachform">
    <li>
      <div class="vocation">
        所属企业：<select class="select3" name="companyId">
        <option>全部企业</option>
        <option>青软实训</option>
        <option>凌志软件</option>
      </select>
      </div>
    </li>
    <li>
      <div class="vocation">
        所属职位：<select class="select3" name="jobId">
        <option>全部职位</option>
        <option>对日外包</option>
        <option>Java软件开发</option>
      </select>
      </div>
    </li>
    <li>
      申请日期：<input name="" type="text" onclick="SelectDate(this)" readonly="readonly" class="scinput"/>
      --<input name="" type="text" onclick="SelectDate(this)" readonly="readonly" class="scinput"/>
    </li>
    <li>
      <input name="" type="button" class="scbtn" value="查询"/>
    </li>
  </ul>
</div>--%>
