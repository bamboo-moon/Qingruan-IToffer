package servlet.admin;

import bean.Admin;
import dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAdmin")
public class FindAdminServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询所有admin信息

        List<Admin> adminList = AdminDao.getAllAdmin();
        //转发
        request.setAttribute("adminList",adminList);
        request.getRequestDispatcher("admin/page/info/adminList.jsp").forward(request,response);
    }
}
