package servlet.user;

import bean.User;
import dao.EduDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/saveUserDegree")
public class SaveUserDegreeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String edu_college=request.getParameter("eduCollege");
        String edu_time=request.getParameter("eduTime");
        String edu_zhuanye=request.getParameter("eduZhuanye");
        int user_id= ((User)request.getSession().getAttribute("user")).getUserId();

        if(edu_college.isEmpty()||edu_time.isEmpty()||edu_zhuanye.isEmpty()||user_id==0){
            request.setAttribute("addError","所填内容不能为空");
            request.getRequestDispatcher("user/applicant/resumeDegreeInfoAdd.jsp").forward(request,response);
        }else{
            int i = EduDao.addEdu(edu_college, edu_time, edu_zhuanye, user_id);
            if(i>0){
                response.sendRedirect("findUserById");
            }else{
                request.setAttribute("addError","添加教育经历失败");
                request.getRequestDispatcher("user/applicant/resumeDegreeInfoAdd.jsp").forward(request,response);
            }
        }


    }
}
