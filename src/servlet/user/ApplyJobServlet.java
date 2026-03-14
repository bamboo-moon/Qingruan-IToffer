package servlet.user;

import bean.Job;
import bean.User;
import dao.CompanyDao;
import dao.JobDao;
import dao.UserJobDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/applyjob")
public class ApplyJobServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");

        if (user != null && user.getUserName()!= null) {
            int userId = user.getUserId();
            int job_id = Integer.parseInt(request.getParameter("job_id"));


            int i1 = UserJobDao.userHasJob(userId, job_id);
            //add前先查重
            if(i1==0){
                int i = UserJobDao.addJob(userId, job_id);
                if (i > 0) {
                    Job job= JobDao.findJobByJobId(job_id);
                    job.setComName(CompanyDao.getCompanyById(job.getCompanyId()).getCompanyName());
                    request.setAttribute("job",job);

                    request.getRequestDispatcher("user/recruit/applysuccess.jsp").forward(request,response);

                } else {
                    String referer = request.getHeader("Referer");
                    request.setAttribute("addError", "申请失败");
                    request.getRequestDispatcher(referer).forward(request, response);
                }
            }else{
                request.getRequestDispatcher("indexUser").forward(request,response);
            }

        }else{
            response.sendRedirect("user/applicant/resumeBasicInfoAdd.jsp");
        }
    }
}
