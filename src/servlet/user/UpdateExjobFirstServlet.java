package servlet.user;

import bean.Exjob;
import dao.ExJobDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateExjobfirst")
public class UpdateExjobFirstServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int exjob_id = Integer.parseInt(request.getParameter("exjob_id"));
        Exjob exjob = ExJobDao.findExjobByExjobId(exjob_id);
        request.setAttribute("exjob",exjob);
        request.getRequestDispatcher("user/applicant/updatExjob.jsp").forward(request,response);

    }
}
