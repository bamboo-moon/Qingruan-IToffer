package servlet.job;

import bean.Job;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static dao.JobDao.findJobByJobnameAndComID;

@WebServlet("/jobSearch")
public class SearchJobByAdmin extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("companyID"));

        int comId = Integer.parseInt(request.getParameter("companyID"));
        String jobName=request.getParameter("jobName");
        List<Job> jobList = findJobByJobnameAndComID(comId,jobName);
        request.setAttribute("jobList",jobList);
        request.getRequestDispatcher("admin/page/job/jobList.jsp").forward(request,response);
    }
}
