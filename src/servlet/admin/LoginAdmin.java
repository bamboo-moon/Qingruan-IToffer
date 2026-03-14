package servlet.admin;

import bean.Admin;
import dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginAdmin")
public class LoginAdmin extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String adminLogin = request.getParameter("adminLogin");
        String adminPwd = request.getParameter("adminPwd");
        String checkCode = request.getParameter("checkCode");//登录时填写验证码
        //得到session中存储的生成验证码
        String validateCode = (String)request.getSession().getAttribute("validateCode");
        if(checkCode.equalsIgnoreCase(validateCode)){
            //验证码正确

            Admin admin = AdminDao.adminLogin(adminLogin,adminPwd);
            if(admin!=null){
                //成功
                if(admin.getAdminStatus()==0){
                    request.getSession().setAttribute("admin",admin);
                    response.sendRedirect("admin/page/main/main.jsp");
                }else{
                    request.setAttribute("loginError","该用户已禁用");
                    request.getRequestDispatcher("admin/login.jsp").forward(request,response);
                }
            }else{
                request.setAttribute("loginError","账号或密码错误");
                request.getRequestDispatcher("admin/login.jsp").forward(request,response);
            }
        }else{
            request.setAttribute("loginError","验证码错误");
            request.getRequestDispatcher("admin/login.jsp").forward(request,response);
        }

    }
}
