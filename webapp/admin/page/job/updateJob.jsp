<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


        <font color="red">${updateError}</font>
        <form name="frm" action="${pageContext.request.contextPath}/updatejobsecond?job_id=${job.jobId}" method="post"  >
            <div class="tabson">
                <ul class="forminfo">
                    <li>
                        <label>职位名称<b>*</b></label>
                        <input name="jobName" type="text" value="${job.jobName}"  class="dfinput" style="width:518px;"/>
                    </li>
                    <li>
                        <label>所属企业<b>*</b></label>
                        <%--<input type="hidden" name="companyId" value="${company.companyId}">--%>
                        <input name="companyName" type="text"  class="dfinput" value="${job.comName}(若要更改企业，请删除后在对应企业处添加)" disabled style="width:518px;"/>
                    </li>
                    <li>
                        <label>招聘人数<b>*</b></label>
                        <input name="jobCount" type="text"  class="dfinput" value="${job.jobCount}" style="width:518px;"/>
                    </li>
                    <li>
                        <label>薪资范围<b>*</b></label>
                        <input name="jobSal" type="text"  class="dfinput" value="${job.jobSal}" style="width:518px;"/>
                    </li>
                    <li>
                        <label>工作地点<b>*</b></label>
                        <input name="jobLoc" type="text"  class="dfinput" value="${job.jobLoc}" style="width:518px;"/>
                    </li>
                    <li>
                        <label>学历<b>*</b></label>
                        <input name="jobDegree" type="text"  class="dfinput" value="${job.jobDegree}" style="width:518px;"/>
                    </li>
                    <li>
                        <label>专业<b>*</b></label>
                        <input name="jobSubject" type="text"  class="dfinput" value="${job.jobSubject}" style="width:518px;"/>
                    </li>
                    <li>
                        <label>工作经验<b>*</b></label>
                        <input name="jobYear" type="text"  class="dfinput" value="${job.jobYear}" style="width:518px;"/>
                    </li>
                    <li>
                        <p>职位描述&nbsp;(不超过1000字)</p>
                        <textarea class="ckeditor" cols="50"  name="jobDesc"  rows="10">
                            ${job.jobDesc}
                        </textarea>
                    </li>
                    <li>
                        <p>任职要求：&nbsp;(不超过1000字)</p>
                        <textarea class="ckeditor" cols="50"  name="jobDetail" rows="10">
                            ${job.jobDetail}
                        </textarea>
                    </li>
                    <li>
                        <label>招聘状态</label>
                        <div class="vocation">

                            <select name="jobStatus" class="select3">

                                <c:if  test="${job.jobStatus==0}">
                                    <option value="0" selected="selected">招聘中</option>
                                    <option value="1">已结束</option>
                                </c:if>
                                <c:if  test="${job.jobStatus==1}">
                                    <option value="0" >招聘中</option>
                                    <option value="1" selected="selected">已结束</option>
                                </c:if>
                            </select>

                        </div>
                    </li>
                    <li>  <label>&nbsp;</label>
                        <input name="" type="submit" class="btn" value="更新"/>

                    <a href="${pageContext.request.contextPath}/findJob">
                         <input name="" type="button" class="btn" value="取消"/>
                    </a>


                    </li>
                </ul>
            </div>
        </form>




    </div>
</div>
</body>
</html>
