package servlet.user;

import bean.User;
import dao.UserJobDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUserJob")
public class DeleteUserJobServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int job_id = Integer.parseInt(request.getParameter("job_id"));
        User user = (User)request.getSession().getAttribute("user");
        int user_id=user.getUserId();
        UserJobDao.deleteUserJob(user_id,job_id);

        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);


    }
}
