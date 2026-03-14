<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>我的工作申请 - 锐聘网</title>
<link href="${pageContext.request.contextPath}/user/css/base.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/user/css/myapplys.css" rel="stylesheet" type="text/css" />
</head>
<body>
<iframe src="${pageContext.request.contextPath}/user/top.jsp" width="100%" height="100"  scrolling="no" frameborder="0" ></iframe>
<div id="tn-content" class="tn-content-bg">
  <div class="tn-wrapper">
    <div class="tn-grid">
      <div class="it-content-box it-person">
        <div class="tn-box-content">
          <div class="tn-tabs">
            <ul class="tn-tabs-nav tn-widget-content ">
              <li> <a href="${pageContext.request.contextPath}/findUserById">我的简历</a></li>
              <li class="tn-tabs-selected"> <a href="${pageContext.request.contextPath}/jobApply">我的申请</a></li>
            </ul>



            <div class="tn-tabs-panel tn-widget-content">
              <form action="#" method="post" id="Form-Apply">
                <table class="tn-table-grid">
                  <tbody>


                    <tr class="tn-table-grid-header">
                      <th class="tn-width-check"> <input type="checkbox" class="tn-checkbox" id="selectAll" name="selectall">
                      </th>
                      <th> 企业名称 </th>
                      <th class="it-text-ctnter"> 职位名称 </th>
                      <th class="it-text-ctnter"> 申请状态 </th>
                      <th> </th>
                    </tr>

<c:forEach items="${jobs}" var="job"><%--再加一些状态变化--%>
    <c:if test="${job.userJobStatus==0}">
    <tr class="tn-table-grid-row">
        <td class="tn-width-check"><input type="checkbox" class="tn-checkbox tnui-apply" value="494" name="applyIdList"></td>
        <td class="tn-width-auto"><a   href="${pageContext.request.contextPath}/userFindCompanyById?companyId=${job.companyId}" target="_blank"> ${job.comName}</a></td>
        <th class="tn-width-pic-mini"> <a  href="${pageContext.request.contextPath}/findJobByJobId?jobId=${job.jobId}" target="_blank"> ${job.jobName}</a> </th>
        <td class="tn-width-category"><div class="tn-instructions">
            <div class="it-instructions-tit">
                <span style="width: 26px">申请</span><span style="width: 132px">审核</span><span style="width: 132px">通知</span>
            </div>
            <div class="tn-progress-bar tn-widget-content tn-corner-all">
                    <div style="width: 50%;" class="tn-progress-bar-value tn-widget-header tn-corner-left tn-border-tbl">
                    </div>
            </div>
            <ul class="tn-helper-clearfix tn-step-scale"></ul></div>
        </td>
        <td class="tn-width-action2">
            <span class="tn-action">
                <a class="tn-action tn-action-text-icon tnui-apply-delete" href="/deleteUserJob?job_id=${job.jobId}" onclick="return confirm('您确定要取消这条申请吗')">
                    <span class="tn-icon it-icon-delete"></span>
                    <span class="tn-action-text">删除</span>
                </a>
            </span>
        </td>
    </tr>
                </c:if>
    <c:if test="${job.userJobStatus==1}">
        <tr class="tn-table-grid-row">
            <td class="tn-width-check"><input type="checkbox" class="tn-checkbox tnui-apply" value="494" name="applyIdList"></td>
            <td class="tn-width-auto"><a   href="${pageContext.request.contextPath}/userFindCompanyById?companyId=${job.companyId}" target="_blank"> ${job.comName}</a></td>
            <th class="tn-width-pic-mini"> <a  href="${pageContext.request.contextPath}/findJobByJobId?jobId=${job.jobId}" target="_blank"> ${job.jobName}</a> </th>
            <td class="tn-width-category"><div class="tn-instructions">
                <div class="it-instructions-tit">
                    <span style="width: 26px"></span><span style="width: 132px"><font color="green"><b>已通过</b></font></span><span style="width: 132px"></span>
                </div>
                <div class="tn-progress-bar tn-widget-content tn-corner-all">
                    <div style="width: 100%;" class="tn-progress-bar-value tn-widget-header tn-corner-left tn-border-tbl">
                    </div>
                </div>
                <ul class="tn-helper-clearfix tn-step-scale"></ul></div>
            </td>
            <td class="tn-width-action2">
            <span class="tn-action">
                <a class="tn-action tn-action-text-icon tnui-apply-delete" href="/deleteUserJob?job_id=${job.jobId}" onclick="return confirm('您确定要取消这条申请吗')">
                    <span class="tn-icon it-icon-delete"></span>
                    <span class="tn-action-text">删除</span>
                </a>
            </span>
            </td>
        </tr>
    </c:if>
    <c:if test="${job.userJobStatus==2}">
        <tr class="tn-table-grid-row">
            <td class="tn-width-check"><input type="checkbox" class="tn-checkbox tnui-apply" value="494" name="applyIdList"></td>
            <td class="tn-width-auto"><a   href="${pageContext.request.contextPath}/userFindCompanyById?companyId=${job.companyId}" target="_blank"> ${job.comName}</a></td>
            <th class="tn-width-pic-mini"> <a  href="${pageContext.request.contextPath}/findJobByJobId?jobId=${job.jobId}" target="_blank"> ${job.jobName}</a> </th>
            <td class="tn-width-category"><div class="tn-instructions">
                <div class="it-instructions-tit">
                    <span style="width: 26px"></span><span style="width: 132px"><font color="red"><b>已驳回</b></font></span><span style="width: 132px"></span>
                </div>
                <div class="tn-progress-bar tn-widget-content tn-corner-all">
                    <div style="width: 0;" class="tn-progress-bar-value tn-widget-header tn-corner-left tn-border-tbl">
                    </div>
                </div>
                <ul class="tn-helper-clearfix tn-step-scale"></ul></div>
            </td>
            <td class="tn-width-action2">
            <span class="tn-action">
                <a class="tn-action tn-action-text-icon tnui-apply-delete" href="/deleteUserJob?job_id=${job.jobId}" onclick="return confirm('您确定要取消这条申请吗')">
                    <span class="tn-icon it-icon-delete"></span>
                    <span class="tn-action-text">删除</span>
                </a>
            </span>
            </td>
        </tr>
    </c:if>
</c:forEach>

                  </tbody>
                </table>
              </form>





            </div>




          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</div>
<iframe src="${pageContext.request.contextPath}/user/foot.jsp" width="100%" height="150"  scrolling="no" frameborder="0" ></iframe>
</body>
</html>
