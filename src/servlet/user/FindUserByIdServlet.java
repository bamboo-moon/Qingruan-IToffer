package servlet.user;

import bean.Edu;
import bean.Exjob;
import bean.Languege;
import bean.User;
import dao.EduDao;
import dao.ExJobDao;
import dao.LanguageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findUserById")
public class FindUserByIdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");

        if (user!= null&& user.getUserName()!= null) {
              int user_id=user.getUserId();
             System.out.println("user = " + user);
             List<Edu> eduByUserId = EduDao.findEduByUserId(user_id);
             List<Languege> lanByUserId = LanguageDao.findLanByUserId(user_id);
            List<Exjob> exjobByUserId = ExJobDao.findExjobByUserId(user_id);

            request.setAttribute("user", user);
            request.setAttribute("edus", eduByUserId);
            request.setAttribute("lans", lanByUserId);
            request.setAttribute("exjobs",exjobByUserId);
            //这边得把edu等信息也填写 转发后全部在另外一个页面显示

            request.getRequestDispatcher("user/applicant/resume.jsp").forward(request, response);
        }else{
            response.sendRedirect("user/applicant/resumeBasicInfoAdd.jsp");
        }

    }
}
