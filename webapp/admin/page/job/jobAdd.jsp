<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="utf-8">
<title>添加职位</title>
<link href="${pageContext.request.contextPath}/admin/css/manageadmin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/ckeditor/ckeditor.js"></script>
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="${pageContext.request.contextPath}/admin/page/main/index.jsp">首页</a></li>
    <li><a href="#">添加职位</a></li>
  </ul>
</div>
<div class="formbody">
  <div class="usual">
  <form name="frm" action="${pageContext.request.contextPath}/saveJob" method="post"  >
    <div class="tabson">
      <ul class="forminfo">
      	<li>
          <label>职位名称<b>*</b></label>
          <input name="jobName" type="text"  class="dfinput" style="width:518px;"/>
        </li>
        <li>
          <label>所属企业<b>*</b></label>
          <input type="hidden" name="companyId" value="${company.companyId}">
          <input name="companyName" type="text"  class="dfinput" value="${company.companyName}" disabled style="width:518px;"/>
        </li>
        <li>
          <label>招聘人数<b>*</b></label>
          <input name="jobCount" type="text"  class="dfinput" style="width:518px;"/>
        </li>
        <li>
          <label>薪资范围<b>*</b></label>
          <input name="jobSal" type="text"  class="dfinput" style="width:518px;"/>
        </li>
        <li>
          <label>工作地点<b>*</b></label>
          <input name="jobLoc" type="text"  class="dfinput" style="width:518px;"/>
        </li>
        <li>
          <label>学历<b>*</b></label>
          <input name="jobDegree" type="text"  class="dfinput" style="width:518px;"/>
        </li>
        <li>
          <label>专业<b>*</b></label>
          <input name="jobSubject" type="text"  class="dfinput" style="width:518px;"/>
        </li>
        <li>
          <label>工作经验<b>*</b></label>
          <input name="jobYear" type="text"  class="dfinput" style="width:518px;"/>
        </li>
        <li>
          <p>职位描述&nbsp;(不超过1000字)</p>
          <textarea class="ckeditor" cols="50"  name="jobDesc" rows="10"></textarea>
        </li>
        <li>
          <p>任职要求：&nbsp;(不超过1000字)</p>
          <textarea class="ckeditor" cols="50"  name="jobDetail" rows="10"></textarea>
        </li>
        <li>
          <label>招聘状态</label>
          <div class="vocation">
            <select name="jobStatus" class="select3">
              <option value="0">招聘中</option>
              <option value="1">已结束</option>
            </select>
          </div>
        </li>
        <li>  <label>&nbsp;</label>
          <input name="" type="submit" class="btn" value="添加"/>
          <input name="" type="button" onclick="history.back()" class="btn" value="取消"/>
        </li>
      </ul>
    </div>
  </form>
    <font color="red">${saveError}</font>
  </div>
</div>
</body>
</html>
