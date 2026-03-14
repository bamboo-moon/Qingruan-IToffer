package servlet.job;

import bean.Company;
import dao.CompanyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toAddJob")
public class ToAddJobServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  id = request.getParameter("companyId");
        int companyId = Integer.parseInt(id);
        Company company = CompanyDao.getCompanyById(companyId);
        request.setAttribute("company",company);
        request.getRequestDispatcher("admin/page/job/jobAdd.jsp").forward(request,response);
    }
}
