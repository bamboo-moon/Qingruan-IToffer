package servlet.user;

import dao.LanguageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteLan")
public class DeleteLanServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int lanId = Integer.parseInt(request.getParameter("lan_id"));
        LanguageDao.deleteLan(lanId);
        response.sendRedirect("findUserById");
    }

}

