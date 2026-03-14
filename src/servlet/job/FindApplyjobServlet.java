package servlet.job;

import bean.Apply;
import dao.UserJobDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/findApplyjob")
public class FindApplyjobServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//公司名 job名(job) user名(id) userjobstatus
        //两表联查出job和userjob 存入一个只有job user status的东西里面

        ArrayList<Apply> applies = UserJobDao.checkAllApply();
        request.setAttribute("applies",applies);
        request.getRequestDispatcher("admin/page/job/jobDeal.jsp").forward(request,response);

    }
}
