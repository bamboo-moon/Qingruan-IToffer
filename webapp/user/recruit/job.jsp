<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>“锐聘之星”软件设计大赛 - 锐聘网</title>
<link href="${pageContext.request.contextPath}/user/css/base.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/user/css/job.css" type="text/css" rel="stylesheet">
</head>
<body>
<iframe src="${pageContext.request.contextPath}/user/top.jsp" width="100%" height="120" scrolling="no" frameborder="0"> </iframe>
<div class="tn-grid">
  <div class="it-com-keyimg">
    <div class="tn-widget-content"> <img src="${pageContext.request.contextPath}/user/images/635581231315281772.jpg"> </div>
  </div>
</div>
<div class="tn-grid">
  <div class="tn-box-content">
    <div class="it-main">
      <div class="it-ctn-heading">
        <div class="it-title-line">
          <h3>${job.jobName}</h3>
        </div>
      </div>
      <div class="job">
        <table class="it-table">
          <tbody>
            <tr>
              <td class="it-table-title"> 招聘人数： </td>
              <td class="tn-border-rb"> ${job.jobCount}人 </td>
              <td class="it-table-title"> 薪资： </td>
              <td class="tn-border-rb"> ${job.jobSal}/年 </td>
            </tr>
            <tr>

              <td class="it-table-title"> 工作地区： </td>
              <td class="tn-border-rb"> ${job.jobLoc} </td>

              <td class="it-table-title"> 所属公司： </td>
              <td class="tn-border-rb"> ${companyName} </td>
            </tr>
            <tr>
              <td class="it-table-title"> 学历要求： </td>
              <td class="tn-border-rb"> ${job.jobDegree} </td>
              <td class="it-table-title"> 专业要求： </td>
              <td class="tn-border-rb"> ${job.jobSubject} </td>
            </tr>

          </tbody>
        </table>

        <div class="clear"> </div>
        <div class="it-post-text">
          <p> <strong>招聘岗位：</strong>${job.jobName} </p>
          <p class="default"> <strong>学历要求：</strong>${job.jobDegree} </p>
          <p class="default"> <strong>需求人数：</strong>${job.jobCount}人 </p>
          <p class="default"> <strong>工作地点：</strong>${job.jobLoc} </p>
          <p class="default"> <strong>招聘要求：</strong>${job.jobDetail}<strong></strong> </p>
          <p class="default"> <strong>工资待遇：</strong>${job.jobSal}<strong></strong> </p>
        </div>
        <div class="it-requirements-title">
          <h3 class="it-font-size">职位要求</h3>
        </div>
        <div class="it-post-text">
          <p><strong>岗位描述：</strong> ${job.jobDesc}</p>
          <p><strong>任职资格：</strong></p>
          <p><strong>
            ${job.jobDetail}
          </strong>
          <p>&nbsp;</p>
        </div>
        <div class="btn_bot">


          <a class="tn-button-secondary" href="${pageContext.request.contextPath}/userFindCompanyById?companyId=${companyId}" target="_blank">
            <span style="color:#1faebc"  class="tn-button-text">查看公司信息</span>
          </a>


          <c:if test="${job.jobStatus==0}">
            <c:if test="${bool==1}">
              <a  class="tn-button-secondary" href="${pageContext.request.contextPath}/deleteUserJob?job_id=${job.jobId}" onclick="return confirm('您确定要取消这条申请吗')">
                <span class="tn-button-text">此职位已经申请</span>
              </a>
            </c:if>

            <c:if test="${bool==0}">
              <a  class="tn-button-secondary" href="${pageContext.request.contextPath}/applyjob?job_id=${job.jobId}" onclick="return confirm('您确定要申请吗')">
                <span style="color:#1faebc" class="tn-button-text">申请</span>
              </a>
              <font color="red">${addError}</font>
            </c:if>
          </c:if>
          <c:if test="${job.jobStatus==1}">
            <a  class="tn-button-secondary" href="javascript:void(0)" onclick="return confirm('该招聘已结束')">
              <span  class="tn-button-text">已结束</span>
            </a>
            <font color="red">${addError}</font>
          </c:if>



        </div>
        <%--title="您已经申请过！"--%>
      </div>
    </div>


    <iframe src="${pageContext.request.contextPath}/user/applicant/resume_right.jsp" width="290" height="650" scrolling="no" frameborder="0"></iframe>

    <div class="clear"> </div>
  </div>
</div>
<iframe src="${pageContext.request.contextPath}/user/foot.jsp" width="100%" height="150" scrolling="no" frameborder="0"> </iframe>
</body>
</html>