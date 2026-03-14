package servlet.company;

import bean.Company;
import dao.CompanyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatecompanyfirst")
public class UpdateCompanyFirstServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int com_id= Integer.parseInt(request.getParameter("com_id"));
        Company company = CompanyDao.getCompanyById(com_id);
        request.setAttribute("com",company);
        request.getRequestDispatcher("admin/page/company/companyUpdate.jsp").forward(request,response);

    }
}
