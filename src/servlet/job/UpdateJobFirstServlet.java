package servlet.job;

import bean.Job;
import dao.CompanyDao;
import dao.JobDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/updatejobfirst")
public class UpdateJobFirstServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int job_id= Integer.parseInt(request.getParameter("job_id"));
        Job job = JobDao.findJobByJobId(job_id);
        int company_id = job.getCompanyId();

        job.setComName(CompanyDao.getCompanyById(company_id).getCompanyName());


        request.setAttribute("job",job);
        request.getRequestDispatcher("admin/page/job/updateJob.jsp").forward(request,response);
    }
}
