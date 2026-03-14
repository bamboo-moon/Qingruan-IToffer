package servlet.user;

import bean.Edu;
import dao.EduDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateEdufirst")
public class UpdateEduFirstServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eduId = request.getParameter("edu_id");
        int edu_id=Integer.parseInt(eduId);
        Edu edu = EduDao.findEduByEduId(edu_id);
        request.setAttribute("edu",edu);
        request.getRequestDispatcher("user/applicant/updateEdu.jsp").forward(request,response);

    }
}
