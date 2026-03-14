package servlet.job;

import dao.JobDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/saveJob")
public class AddJobServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String jobName = request.getParameter("jobName");
        String jobSal = request.getParameter("jobSal");
        String jobLoc = request.getParameter("jobLoc");
        String jobCount = request.getParameter("jobCount");
        String jobDegree = request.getParameter("jobDegree");
        String jobSubject = request.getParameter("jobSubject");
        String jobDesc = request.getParameter("jobDesc");
        String jobDetail = request.getParameter("jobDetail");
        String jobYear = request.getParameter("jobYear");
        String status = request.getParameter("jobStatus");
        int jobStatus = Integer.parseInt(status);
        String cid = request.getParameter("companyId");
        int companyId = Integer.parseInt(cid);

        int num = JobDao.addJob(jobName,jobSal,jobLoc,jobCount,jobDegree,jobSubject,jobDesc,jobDetail,jobStatus,jobYear,companyId);
        if(num>0){
            //成功跳转到职位展示页面
            response.sendRedirect("findJob");
        }else{
            request.setAttribute("addError","添加失败");
            request.getRequestDispatcher("admin/page/job/jobAdd.jsp").forward(request,response);
        }



    }
}
