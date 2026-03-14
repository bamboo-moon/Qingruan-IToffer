package servlet.job;

import dao.JobDao;
import dao.UserJobDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletejob")
public class DeleteJobServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int job_id= Integer.parseInt(request.getParameter("job_id"));
        JobDao.deleteJob(job_id);
        UserJobDao.deleteUserJob(job_id);
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);
    }
}
