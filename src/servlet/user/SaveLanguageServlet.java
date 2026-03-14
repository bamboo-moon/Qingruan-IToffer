package servlet.user;

import bean.User;
import dao.LanguageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/saveLanguage")
public class SaveLanguageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String lan_name=request.getParameter("lan_name");
        String lan_listen=request.getParameter("lan_listen");
        String lan_write=request.getParameter("lan_write");
        String lan_level=request.getParameter("lan_level");
        int user_id= ((User)request.getSession().getAttribute("user")).getUserId();

        if(lan_name.isEmpty()||lan_listen.isEmpty()||lan_write.isEmpty()||lan_level.isEmpty()||user_id==0){
            request.setAttribute("addError","所填内容不能为空");
            request.getRequestDispatcher("user/applicant/languageAdd.jsp").forward(request,response);
        }else{
            int i = LanguageDao.addLan(lan_name, lan_listen, lan_write, lan_level, user_id);
            if(i>0){
                response.sendRedirect("findUserById");
            }else{
                request.setAttribute("addError","添加语言能力失败");
                request.getRequestDispatcher("user/applicant/languageAdd.jsp").forward(request,response);
            }
        }

    }
}
