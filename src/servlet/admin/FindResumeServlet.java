package servlet.admin;

import bean.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findresume")
public class FindResumeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> allUser = UserDao.getAllUser();
        request.setAttribute("users",allUser);
        request.getRequestDispatcher("admin/page/resume/resumeList.jsp").forward(request,response);
    }
}
