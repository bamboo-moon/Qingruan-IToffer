package servlet.admin;

import bean.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/watchresume")
public class WatchResumeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int user_id= Integer.parseInt(request.getParameter("user_id"));
        User user = UserDao.findUserById(user_id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("admin/page/resume/resumeView.jsp").forward(request,response);
    }
}
