package servlet.user;

import bean.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginUser")
public class LoginUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userCode = request.getParameter("userCode");
        String userPwd = request.getParameter("userPwd");

        User user = UserDao.userLogin(userCode,userPwd);
        if(user!=null){
            //把用户信息存储到session中
            request.getSession().setAttribute("user",user);
            response.sendRedirect("indexUser");
        }else{
            request.setAttribute("loginError","账号或密码错误");
            request.getRequestDispatcher("user/login.jsp").forward(request,response);
        }
    }
}
