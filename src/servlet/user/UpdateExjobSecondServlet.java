package servlet.user;

import dao.ExJobDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateExjobsecond")
public class UpdateExjobSecondServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int exjob_id = Integer.parseInt(request.getParameter("exjob_id"));
        String exjob_loc = request.getParameter("exjob_loc");
        String exjob_time = request.getParameter("exjob_time");
        String exjob_name = request.getParameter("exjob_name");

        if(exjob_loc.isEmpty()||exjob_time.isEmpty()||exjob_name.isEmpty()){
            request.setAttribute("updateError","所填内容不能为空");
            request.getRequestDispatcher("updateExjobfirst").forward(request,response);
        }else{
            ExJobDao.updateExjob(exjob_id,exjob_loc,exjob_time,exjob_name);
            response.sendRedirect("findUserById");
        }

    }
}
