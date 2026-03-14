package servlet.user;

import dao.ExJobDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteExjob")
public class DeleteExjobServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int exjob_id = Integer.parseInt(request.getParameter("exjob_id"));
        ExJobDao.deleteExjob(exjob_id);
        response.sendRedirect("findUserById");

    }
}
