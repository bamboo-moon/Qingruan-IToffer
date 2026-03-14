package servlet.user;

import bean.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/resumeBasicInfoUpdate")
@MultipartConfig
public class resumeBasicinfoUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int userId = ((User)request.getSession().getAttribute("user")).getUserId();

        String userName = request.getParameter("userName");
        String userSex = request.getParameter("userSex");
        String userEmail = request.getParameter("userEmail");
        String userBirthday = request.getParameter("userBirthday");
        String userWork = request.getParameter("userWork");
        String userYear = request.getParameter("userYear");
        String userPhone = request.getParameter("userPhone");

        Part part = request.getPart("uploadImg");
        String oldFileName = part.getSubmittedFileName();

        //需要判断是否和当前头像一样

        String fileName;
        if(oldFileName.isEmpty()){
            fileName=((User)request.getSession().getAttribute("user")).getUserImg();
        }
        else{
            String typeName = oldFileName.substring(oldFileName.lastIndexOf("."));
            String uuid = UUID.randomUUID().toString();
            fileName = uuid+typeName;
            String path = request.getServletContext().getRealPath("/");
            part.write(path+"/upload/"+fileName);
        }

        if(userName.isEmpty()||userSex.isEmpty()||userBirthday.isEmpty()||userWork.isEmpty()|| userYear.isEmpty()||userPhone.isEmpty()||fileName.isEmpty()||userEmail.isEmpty()||userId==0){
            request.setAttribute("saveError","简历不可为空");
            request.setAttribute("user",(User)request.getSession().getAttribute("user"));
            request.getRequestDispatcher("user/applicant/resumeBasicInfoUpdate.jsp").forward(request,response);
        }else{
            int num =UserDao.updateUserInfo(userName,userSex,userBirthday,userWork,userYear,userPhone,fileName,userEmail,userId);
            if(num>0){
                request.getSession().setAttribute("user", UserDao.findUserById(userId));
                response.sendRedirect("findUserById");
            }else{
                request.setAttribute("saveError","简历修改失败");
                request.getRequestDispatcher("user/applicant/resumeBasicInfoAdd.jsp").forward(request,response);
            }
        }


    }
}
