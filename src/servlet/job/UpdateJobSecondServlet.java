package servlet.job;

import dao.JobDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatejobsecond")
public class UpdateJobSecondServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int job_id = Integer.parseInt(request.getParameter("job_id"));

        String jobName = request.getParameter("jobName");
        String jobCount = request.getParameter("jobCount");
        String jobSal = request.getParameter("jobSal");
        String jobLoc = request.getParameter("jobLoc");
        String jobDegree = request.getParameter("jobDegree");
        String jobSubject = request.getParameter("jobSubject");
        String jobYear = request.getParameter("jobYear");
        String jobDesc = request.getParameter("jobDesc");
        String jobDetail = request.getParameter("jobDetail");
        int jobStatus = Integer.parseInt(request.getParameter("jobStatus"));


        if(jobName.isEmpty()||jobCount.isEmpty()||jobSal.isEmpty()||jobLoc.isEmpty()||jobDegree.isEmpty()||
                jobSubject.isEmpty()||jobYear.isEmpty()||jobDesc.isEmpty()||jobDetail.isEmpty())
        {
            request.setAttribute("updateError","所填内容不能为空");
            request.getRequestDispatcher("updatejobfirst").forward(request,response);
        }else{
            JobDao.updateJob(job_id,jobName,jobSal,jobLoc,jobCount,jobDegree,jobSubject,jobDesc,jobDetail,jobStatus,jobYear);

            response.sendRedirect("findJob");
        }


    }
}
