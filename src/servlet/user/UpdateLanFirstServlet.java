package servlet.user;

import bean.Languege;
import dao.LanguageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateLanfirst")
public class UpdateLanFirstServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lanId = request.getParameter("lan_id");
        int lan_id=Integer.parseInt(lanId);
        Languege lan = LanguageDao.findLanByLanId(lan_id);
        request.setAttribute("lan",lan);
        request.getRequestDispatcher("user/applicant/updateLan.jsp").forward(request,response);

    }
}
