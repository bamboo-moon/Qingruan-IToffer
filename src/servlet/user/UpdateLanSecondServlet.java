package servlet.user;

import dao.LanguageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateLansecond")
public class UpdateLanSecondServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int lan_id = Integer.parseInt(request.getParameter("lan_id"));
        String lan_name = request.getParameter("lan_name");
        String lan_listen = request.getParameter("lan_listen");
        String lan_write = request.getParameter("lan_write");
        String lan_level = request.getParameter("lan_level");

        if(lan_name.isEmpty()||lan_listen.isEmpty()||lan_write.isEmpty()||lan_level.isEmpty()){
            request.setAttribute("updateError","所填内容不能为空");
            request.getRequestDispatcher("updateLanfirst").forward(request,response);
        }else{
            LanguageDao.updateLan(lan_id, lan_name, lan_listen, lan_write,lan_level);
            response.sendRedirect("findUserById");
        }

    }
}

