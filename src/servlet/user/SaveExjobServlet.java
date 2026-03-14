package servlet.user;

import bean.User;
import dao.ExJobDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/saveexjob")
public class SaveExjobServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String exjobLoc = request.getParameter("exjob_loc");
        String exjobTime = request.getParameter("exjob_time");
        String exjobName = request.getParameter("exjob_name");
        int user_id= ((User)request.getSession().getAttribute("user")).getUserId();

        if(exjobLoc.isEmpty()||exjobTime.isEmpty()||exjobName.isEmpty()||user_id==0){
            request.setAttribute("addError","所填内容不能为空");
            request.getRequestDispatcher("user/applicant/exjobAdd.jsp").forward(request,response);
        }else{
            int i = ExJobDao.addExjob(exjobLoc, exjobTime, exjobName, user_id);
            if(i>0){
                response.sendRedirect("findUserById");
            }else{
                request.setAttribute("addError","添加语言能力失败");
                request.getRequestDispatcher("user/applicant/exjobAdd.jsp").forward(request,response);
            }
        }


    }
}
