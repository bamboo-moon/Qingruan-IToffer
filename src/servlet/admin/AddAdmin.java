package servlet.admin;

import dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/saveAdmin")//java中处理器的请求路径 不受类所在包的影响
public class AddAdmin extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String adminLogin = request.getParameter("adminLogin");
        String adminPwd = request.getParameter("adminPwd");
        String adminName = request.getParameter("adminName");
        String adminEmail = request.getParameter("adminEmail");
        String adminRole = request.getParameter("adminRole");
        String status = request.getParameter("adminStatus");
        int adminStatus = Integer.parseInt(status);
        //保存到数据库

        int num = AdminDao.addAdmin(adminLogin,adminPwd,adminName,adminEmail,adminRole,adminStatus);
        if(num>0){
            //保存成功  回到展示页面
            response.sendRedirect("admin/page/info/adminList.jsp");
        }else{
            request.setAttribute("saveError","添加失败");
            request.getRequestDispatcher("admin/page/info/adminAdd.jsp").forward(request,response);
        }

    }
}
