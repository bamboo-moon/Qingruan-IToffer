package servlet.admin;

import bean.Admin;
import dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//修改的数据回显  根据要修改数据的id  反查数据库  得到该数据的完整信息   回显到修改页面
@WebServlet("/findAdminById")
public class FindAdminByIdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("adminId");
        int adminId = Integer.parseInt(id);

        Admin admin = AdminDao.getAdminById(adminId);
        request.setAttribute("admin",admin);
        request.getRequestDispatcher("admin/page/info/adminUpdate.jsp").forward(request,response);
    }
}
