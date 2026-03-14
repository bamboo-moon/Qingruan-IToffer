package servlet.user;

import dao.EduDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteEdu")
public class DeleteEduServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int eduId = Integer.parseInt(request.getParameter("edu_id"));
        EduDao.deleteEdu(eduId);

        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);

    }
}
