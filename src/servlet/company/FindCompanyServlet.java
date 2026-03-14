package servlet.company;

import bean.Company;
import dao.CompanyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllCompany")
public class FindCompanyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Company> companyList = CompanyDao.getAllCompany();
        request.setAttribute("companyList",companyList);
        request.getRequestDispatcher("admin/page/company/companyList.jsp").forward(request,response);
    }
}
