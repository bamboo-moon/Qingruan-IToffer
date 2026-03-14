package servlet.company;

import bean.Company;
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
import java.util.List;

//用户端根据id获取企业详情
@WebServlet("/userFindCompanyById")
public class UserCompanyByIdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("companyId");
        int companyId = Integer.parseInt(id);

        Company company = CompanyDao.getCompanyById(companyId);
        //把该企业对应的招聘信息查询出来 并展示在企业简介页面

        List<Job> jobList = JobDao.findJobByCompanyId(companyId);
        request.setAttribute("company",company);
        request.setAttribute("jobList",jobList);

        User user=(User)request.getSession().getAttribute("user");
        if(user==null){
            response.sendRedirect("user/login.jsp");
        }else{
            int userId = user.getUserId();
            for (Job job : jobList) {
                job.setUserHasJob(UserJobDao.userHasJob(userId, job.getJobId()));
            }
            request.getRequestDispatcher("user/recruit/company.jsp").forward(request,response);
        }


    }
}
