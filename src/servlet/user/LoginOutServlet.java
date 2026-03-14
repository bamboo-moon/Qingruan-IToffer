package servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginOut")
public class LoginOutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //退出  销毁session  重定向到登录页面
        //request.getSession().removeAttribute("user");//从session中移除指定属性
        request.getSession().invalidate();//销毁当前session
        response.sendRedirect("user/login.jsp");
    }
}
