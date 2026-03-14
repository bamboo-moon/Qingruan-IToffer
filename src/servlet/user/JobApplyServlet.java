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
import java.util.ArrayList;

@WebServlet("/jobApply")
public class JobApplyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = ((User)request.getSession().getAttribute("user")).getUserId();
        ArrayList<Integer> jidByUid = UserJobDao.findJidByUid(userId);
        ArrayList<Job> jobs=new ArrayList<>();
        for (Integer jobId : jidByUid) {
            Job job = JobDao.findJobByJobId(jobId);
            if(job!=null){
                int comId = job.getCompanyId();
                String comName = CompanyDao.getCompanyById(comId).getCompanyName();
                job.setComName(comName);
                job.setUserJobStatus(UserJobDao.userJobStatus(userId, jobId));
                jobs.add(job);
            }
        }
        request.setAttribute("jobs",jobs);
        request.getRequestDispatcher("user/applicant/jobApply.jsp").forward(request,response);
    }
}
