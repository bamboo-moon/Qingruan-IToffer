package servlet.admin;

import bean.Admin;
import dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateAdminStatus")
public class UpdateAdminStatusServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("adminId");
        int adminId = Integer.parseInt(id);
        Admin loginAdmin = (Admin)request.getSession().getAttribute("admin");
        int loginId = loginAdmin.getAdminId();
        if(loginId == adminId){
            request.setAttribute("statusError","登录人不能操作自身状态");
            request.getRequestDispatcher("admin/page/main/index.jsp").forward(request,response);
        }else{
            String status = request.getParameter("adminStatus");
            int adminStatus = Integer.parseInt(status);
            int num = AdminDao.updateAdminStatus(adminStatus,adminId);
            if(num>0){
                response.sendRedirect("findAdmin");
            }
        }

    }
}
