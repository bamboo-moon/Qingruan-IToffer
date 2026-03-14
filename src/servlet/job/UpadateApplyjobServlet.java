package servlet.job;

import dao.UserJobDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auditApp")
public class UpadateApplyjobServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userjob_id= Integer.parseInt(request.getParameter("userjob_id"));
        int pass= Integer.parseInt(request.getParameter("pass"));
        if(pass==1){
            UserJobDao.updateStatus(1,userjob_id);
        } else {
            UserJobDao.updateStatus(2,userjob_id);
        }
        response.sendRedirect("findApplyjob");
    }
}
