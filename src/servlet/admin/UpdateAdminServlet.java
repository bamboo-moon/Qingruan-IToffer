package servlet.admin;

import bean.Admin;
import dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateAdmin")
public class UpdateAdminServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("adminId");
        int adminId = Integer.parseInt(id);
        String adminLogin = request.getParameter("adminLogin");
        String adminName = request.getParameter("adminName");
        String adminPwd = request.getParameter("adminPwd");
        String adminEmail = request.getParameter("adminEmail");
        String adminRole = request.getParameter("adminRole");
        Admin admin  = new Admin();
        admin.setAdminId(adminId);
        admin.setAdminName(adminName);
        admin.setAdminRole(adminRole);
        admin.setAdminEmail(adminEmail);
        admin.setAdminPwd(adminPwd);
        admin.setAdminLogin(adminLogin);
        int num = AdminDao.updateAdmin(admin);
        if(num>0){
            //修改成功 重新展示数据
            response.sendRedirect("findAdmin");
        }else{

            response.sendRedirect("findAdminById");
        }
    }
}
