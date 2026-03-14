<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>我的简历 - 锐聘网</title>
    <link href="${pageContext.request.contextPath}/user/css/base.css" type="text/css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/user/css/my_resume.css" type="text/css" rel="stylesheet" />
    <meta content="大学生求职,大学生就业,大学生招聘,IT人才,IT人才招聘,大学生名企招聘,,大学生找工作,IT名企招聘，IT行业招聘，IT企业快速入职" name="keywords">
    <meta content="锐聘专注于为企业提供高效的人力资源解决方案，同时面向IT类技术人才推出快速一站式免费就业服务。秉承QST青软实训人才服务理念，为数千家企业量身定做个性化、全程化的人才培养体系，同时帮助中高级人才铺设成功之路，为人才和企业架设起沟通之桥。" name="description">

</head>

<body>
<iframe src="${pageContext.request.contextPath}/user/top.jsp" width="100%" height="100"  scrolling="no" frameborder="0" ></iframe>

<div class="resume_con">
    <!--tab设置-->
    <div class="user_operate">
        <ul style="float:left">
            <li><a href="${pageContext.request.contextPath}/findUserById" class="active">我的简历</a></li>
            <li><a href="jobApply.jsp">我的申请</a></li>
            <div class="clear"></div>
        </ul>
        <div class="clear"></div>
    </div>
    <!--主体部分-->
    <div class="resume_main">
        <!--左边-->
        <div class="resume_left">
            <div class="resume_title">
                <div style="float:left">工作经历</div>
            </div>
            <div class="all_resume">


                <form action="${pageContext.request.contextPath}/saveexjob" method="post">
                    <div class="table_style">
                        <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                            <tr>
                                <th width="110" align="right" bgcolor="#F8F8F8">工作公司：</th>
                                <td bgcolor="#F8F8F8"><input type="text" name="exjob_loc" value=""></td>
                            </tr>
                        </table>
                        <div class="he"></div>
                        <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                            <tr>
                                <th width="110" align="right" bgcolor="#F8F8F8">在职时间：</th>
                                <td bgcolor="#F8F8F8"><input type="text" name="exjob_time" value=""></td>
                            </tr>
                        </table>
                        <div class="he"></div>

                        <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                            <tr>
                                <th width="110" align="right" bgcolor="#F8F8F8">职位名称：</th>
                                <td bgcolor="#F8F8F8"><input type="text" name="exjob_name" value=""></td>
                            </tr>
                        </table>
                        <div class="he"></div>



                        <div style="margin-left:100px;"><input name="" type="submit" class="save1" value="保存">
                            <a href="${pageContext.request.contextPath}/findUserById"><input name="" type="text" class="cancel2" value="取消"></a>
                        </div>
                    </div>
                    <div class="clear"></div>
                    <font color="red">${addError}</font>
                </form>
            </div>
        </div>
        <!--右边-->
        <iframe src="${pageContext.request.contextPath}/user/applicant/resume_right.jsp" width="290" height="650" scrolling="no" frameborder="0"></iframe>
        <div style="clear:both"></div>
    </div>
</div>

<iframe src="${pageContext.request.contextPath}/user/foot.jsp" width="100%" height="150"  scrolling="no" frameborder="0" ></iframe>
</body>
</html>
