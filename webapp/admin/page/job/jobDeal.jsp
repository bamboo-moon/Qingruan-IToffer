<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <title>应募列表</title>
    <link href="${pageContext.request.contextPath}/admin/css/manageadmin.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="place"><span>位置：</span>
    <ul class="placeul">
        <li><a href="${pageContext.request.contextPath}/admin/page/main/index.jsp">首页</a></li>
        <li><a href="${pageContext.request.contextPath}/findAppAdmin">应募列表</a></li>
    </ul>
</div>
<div class="rightinfo">

    <table class="imgtable">

        <thead>
        <tr>
            <th>序号</th>
            <th>职位</th>
            <th>所属公司</th>
            <th>申请人</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${applies}" var="apply"  varStatus="status">
                <tr height="50px">
                    <td>${status.index+1}</td>
                    <td>${apply.job.jobName}</td>
                    <td>${apply.job.comName}</td>
                    <td>${apply.user.userName}</td>
                    <td>
                        <c:if test="${apply.status==0}"> 正在受理中 </c:if>
                        <c:if test="${apply.status==1}"><font color="#00bfff"> 已通过申请</font> </c:if>
                        <c:if test="${apply.status==2}"><font color="red"> 已拒绝申请</font> </c:if>
                    </td>

                        <%--这里要跳处理器--%>
                    <td>

                        <c:if test="${apply.status==0}">
                            <a href="${pageContext.request.contextPath}/auditApp?userjob_id=${apply.userjob_id}&pass=1" class="tablelink"
                               onclick="return confirm('确认通过申请吗？')">通过申请</a>&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/auditApp?userjob_id=${apply.userjob_id}&pass=2" class="tablelink"
                               onclick="return confirm('确认拒绝申请吗？')">拒绝申请</a>
                        </c:if>

                        <c:if test="${apply.status==1}">
                            <font color="#00bfff">已通过申请</font>
                        </c:if>
                        <c:if test="${apply.status==2}">
                            <font color="red">已拒绝申请</font>
                        </c:if>

                    </td>

                </tr>

        </c:forEach>


        </tbody>
    </table>

</div>
</body>
</html>
