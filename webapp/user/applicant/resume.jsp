<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>我的简历 - 锐聘网</title>
    <link href="${pageContext.request.contextPath}/user/css/base.css" type="text/css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/user/css/my_resume.css" type="text/css" rel="stylesheet"/>
    <meta content="大学生求职,大学生就业,大学生招聘,IT人才,IT人才招聘,大学生名企招聘,,大学生找工作,IT名企招聘，IT行业招聘，IT企业快速入职"
          name="keywords">
    <meta content="锐聘专注于为企业提供高效的人力资源解决方案，同时面向IT类技术人才推出快速一站式免费就业服务。秉承QST青软实训人才服务理念，为数千家企业量身定做个性化、全程化的人才培养体系，同时帮助中高级人才铺设成功之路，为人才和企业架设起沟通之桥。"
          name="description">
    <style>
        .btn-delete {
            background-color: #e74c3c;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn-delete:hover {
            background-color: #c0392b;
        }
    </style>
</head>

<body>
<iframe src="${pageContext.request.contextPath}/user/top.jsp" width="100%" height="100" scrolling="no"
        frameborder="0"></iframe>

<div class="resume_con">
    <!--tab设置-->
    <div class="user_operate">
        <ul style="float:left">
            <li><a href="${pageContext.request.contextPath}/findUserById" class="active">我的简历</a></li>
            <li><a href="${pageContext.request.contextPath}/jobApply">我的申请</a></li>
            <div class="clear"></div>
        </ul>
        <div class="clear"></div>
    </div>
    <!--主体部分-->
    <div class="resume_main">
        <!--左边-->
        <div class="resume_left">
            <div class="resume_title">
                <div style="float:left">基本信息</div>
                <a href="${pageContext.request.contextPath}/user/applicant/resumeBasicInfoUpdate.jsp"> <div class="btn">修改
                </div></a>
            </div>
            <div class="all_resume">
                <div class="table_style">
                    <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                        <tr>
                            <th width="110" align="right" bgcolor="#F8F8F8">姓名：</th>
                            <td bgcolor="#F8F8F8">${user.userName}</td>
                        </tr>
                    </table>
                    <div class="he"></div>
                    <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                        <tr>
                            <th width="110" align="right" bgcolor="#F8F8F8">性别：</th>
                            <td bgcolor="#F8F8F8">${user.userSex}</td>
                        </tr>
                    </table>
                    <div class="he"></div>
                    <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                        <tr>
                            <th width="110" align="right" bgcolor="#F8F8F8">出生日期：</th>
                            <td bgcolor="#F8F8F8">${user.userBirthday}</td>
                        </tr>
                    </table>
                    <div class="he"></div>
                    <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                        <tr>
                            <th width="110" align="right" bgcolor="#F8F8F8">手机：</th>
                            <td bgcolor="#F8F8F8">${user.userPhone}</td>
                        </tr>
                    </table>
                    <div class="he"></div>
                    <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                        <tr>
                            <th width="110" align="right" bgcolor="#F8F8F8">邮件：</th>
                            <td bgcolor="#F8F8F8">${user.userEmail}</td>
                        </tr>
                    </table>
                    <div class="he"></div>
                    <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                        <tr>
                            <th width="110" align="right" bgcolor="#F8F8F8">求职意向：</th>
                            <td bgcolor="#F8F8F8">${user.userWork}</td>
                        </tr>
                    </table>
                    <div class="he"></div>
                    <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                        <tr>
                            <th width="110" align="right" bgcolor="#F8F8F8">工作经验：</th>
                            <td bgcolor="#F8F8F8">${user.userYear}</td>
                        </tr>
                    </table>
                    <div class="he"></div>
                </div>

                <div style="float:right" class="uploade">
                    <img src="${pageContext.request.contextPath}/upload/${user.userImg}" width="120px" height="120px">
                </div>

                <div class="clear"></div>
            </div>

            <div class="resume_title">
                <div style="float:left">教育经历</div>
                <a href="${pageContext.request.contextPath}/user/applicant/resumeDegreeInfoAdd.jsp">
                    <div class="btn">添加</div>
                </a>
            </div>
            <div class="it-table-grid">
                <ul>
                    <li class="tn-border-gray tn-border-bottom it-table-grid-header">
                        <p class="tn-name">
                            毕业院校</p>
                        <p class="tn-date">
                            就读时间</p>
                        <p class="tn-fieldofstudy">
                            专业</p>
                    </li>

                    <c:forEach items="${edus}" var="edu">
                        <li class="tn-border-gray tn-border-bottom">
                            <p class="tn-name">
                                    ${edu.edu_college}
                            </p>
                            <p class="tn-date">
                                    ${edu.edu_time}
                            </p>

                            <p class="tn-fieldofstudy">
                                    ${edu.edu_zhuanye}
                            </p>
                        <span class="tn-actions">
							<a href="/updateEdufirst?edu_id=${edu.edu_id}" class="tn-action tn-action-text-icon">
			            		<span class="tn-icon it-icon-modify"></span>
								<span class="tn-action-text">修改</span>
							</a>

			                 <a href="/deleteEdu?edu_id=${edu.edu_id}" onclick="return confirm('您确定要删除这条信息吗')" class="tn-action tn-action-text-icon tn-delete">
                                <span class="tn-icon it-icon-delete"></span>
								<span class="tn-action-text">删除</span>
			            	</a>

						</span>
                        </li>
                    </c:forEach>

                </ul>
            </div>





            <div class="resume_title">
                <div style="float:left">工作经历</div>
                <a href="${pageContext.request.contextPath}/user/applicant/exjobAdd.jsp">
                    <div class="btn">添加</div>
                </a>

            </div>
            <div class="it-table-grid">
                <ul>
                    <li class="tn-border-gray tn-border-bottom it-table-grid-header">
                        <p class="tn-name">
                            工作公司 </p>
                        <p class="tn-date">
                            在职时间</p>

                        <p class="tn-fieldofstudy">
                            职位名称</p>
                    </li>

                    <c:forEach items="${exjobs}" var="exjob">
                    <li class="tn-border-gray tn-border-bottom">
                        <p class="tn-name">
                            ${exjob.exjob_loc}
                        </p>
                        <p class="tn-date">
                            ${exjob.exjob_time}
                        </p>

                        <p class="tn-fieldofstudy" >
                            ${exjob.exjob_name}
                        </p>
                        <span class="tn-actions">
                            <a href="${pageContext.request.contextPath}/updateExjobfirst?exjob_id=${exjob.exjob_id}" class="tn-action tn-action-text-icon">
			            <span class="tn-icon it-icon-modify"></span>
                                <span class="tn-action-text">修改</span>
			            </a>

			            <a href="${pageContext.request.contextPath}/deleteExjob?exjob_id=${exjob.exjob_id}" onclick="return confirm('您确定要删除这条信息吗')" class="tn-action tn-action-text-icon tn-delete">
			            <span class="tn-icon it-icon-delete"></span>
                            <span class="tn-action-text">删除</span>
			            </a>

                        </span>
                    </li>
                    </c:forEach>
                </ul>
            </div>




            <div class="resume_title">
                <div style="float:left">语言能力</div>
                <a href="${pageContext.request.contextPath}/user/applicant/languageAdd.jsp">
                <div class="btn">添加</div>
                </a>
            </div>

            <div class="it-table-grid">
                <ul>
                    <li class="tn-border-gray tn-border-bottom it-table-grid-header">
                        <p class="tn-name">
                            语言 </p>
                        <p class="tn-date">
                            听说</p>
                        <p class="tn-degree">
                            读写</p>
                        <p class="tn-fieldofstudy">
                            等级考试</p>
                    </li>

                    <c:forEach items="${lans}" var="lan">
                        <li class="tn-border-gray tn-border-bottom">
                            <p class="tn-name" title="英语">
                                    ${lan.lan_name}
                            </p>
                            <p class="tn-date">
                                    ${lan.lan_listen}
                            </p>
                            <p class="tn-degree" title="">
                                    ${lan.lan_write}
                            </p>
                            <p class="tn-fieldofstudy" title="CET-6">
                                    ${lan.lan_level}
                            </p>
                            <span class="tn-actions">
                                <a href="/updateLanfirst?lan_id=${lan.lan_id}" class="tn-action tn-action-text-icon">
			            <span class="tn-icon it-icon-modify">
                        </span><span class="tn-action-text">修改</span>
			            </a>
			            <a href="/deleteLan?lan_id=${lan.lan_id}" onclick="return confirm('您确定要删除这条信息吗')" class="tn-action tn-action-text-icon tn-delete">
			            <span class="tn-icon it-icon-delete">

                        </span><span class="tn-action-text">删除</span>
			            </a></span></li>
                    </c:forEach>


                </ul>
            </div>



        </div>


        <!--右边-->
             <iframe src="${pageContext.request.contextPath}/user/applicant/resume_right.jsp" width="290" height="650" scrolling="no" frameborder="0"></iframe>
            <div style="clear:both"></div>
        </div>
</div>


<iframe src="${pageContext.request.contextPath}/user/foot.jsp" width="100%" height="150" scrolling="no"
        frameborder="0"></iframe>
</body>
</html>
