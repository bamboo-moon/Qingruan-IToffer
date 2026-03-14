package servlet.user;

import dao.EduDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateEdusecond")
public class UpdateEduSecondServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int eduId = Integer.parseInt(request.getParameter("edu_id"));
        String eduCollege = request.getParameter("edu_college");
        String eduTime = request.getParameter("edu_time");
        String eduZhuanye = request.getParameter("edu_zhuanye");
        if(eduCollege.isEmpty()||eduTime.isEmpty()||eduZhuanye.isEmpty()){
            request.setAttribute("updateError","所填内容不能为空");
            request.getRequestDispatcher("updateEdufirst").forward(request,response);
        }else{
            EduDao.updateEdu(eduId, eduCollege, eduTime, eduZhuanye);
            response.sendRedirect("findUserById");
        }

    }
}
