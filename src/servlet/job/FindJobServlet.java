package servlet.job;

import bean.Job;
import dao.JobDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findJob")
public class FindJobServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Job> jobList = JobDao.findJob();
        request.setAttribute("jobList",jobList);
        request.getRequestDispatcher("admin/page/job/jobList.jsp").forward(request,response);

//还要加上已有企业的名字信息
        // List< Company> companyList= CompanyDao.getAllCompany();
        //request.setAttribute("companies",companyList);
        //request.getRequestDispatcher("${pageContext.request.contextPath}/admin/page/job/jobSearch.jsp").forward(request,response);
    }
}
