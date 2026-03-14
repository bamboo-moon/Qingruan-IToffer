package servlet.job;

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

@WebServlet("/findJobByJobId")
public class FindJobByJobIdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = ((User)request.getSession().getAttribute("user")).getUserId();

        String jid = request.getParameter("jobId");
        int jobId = Integer.parseInt(jid);

        Job job = JobDao.findJobByJobId(jobId);

        int comId=job.getCompanyId();
        String companyName = CompanyDao.getCompanyById(comId).getCompanyName();

        int i= UserJobDao.userHasJob(userId,jobId);

        request.setAttribute("job",job);
        request.setAttribute("companyName",companyName);
        request.setAttribute("companyId",comId);
        request.setAttribute("bool",i);

        request.getRequestDispatcher("user/recruit/job.jsp").forward(request,response);
    }
}
