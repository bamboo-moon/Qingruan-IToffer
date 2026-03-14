package servlet.user;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/regUser")
public class RegUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String userCode = request.getParameter("userCode");
        String userPwd = request.getParameter("userPwd");
        String userPwd1 = request.getParameter("userPwd1");
        String regValidateCode = request.getParameter("regValidateCode");
        if(userPwd.equals(userPwd1)){
            //两次密码一致
            //判断验证码
           String validateCode =(String) request.getSession().getAttribute("validateCode");
           if(validateCode.equalsIgnoreCase(regValidateCode)){
               //验证码正确
               //验证卡号是否已存在

               boolean b = UserDao.checkUserCode(userCode) ;
               if(b){
                    //卡号可以使用
                   //注册
                   int num = UserDao.userReg(userCode,userPwd);
                   if(num>0){
                       response.sendRedirect("user/login.jsp");//???
                   }else{
                       request.setAttribute("regError","注册失败");
                       request.getRequestDispatcher("user/register.jsp").forward(request,response);
                   }
               }else{
                   request.setAttribute("regError","账户已存在");
                   request.getRequestDispatcher("user/register.jsp").forward(request,response);
               }
           }else{
               request.setAttribute("regError","验证码错误");
               request.getRequestDispatcher("user/register.jsp").forward(request,response);
           }
        }else{
            request.setAttribute("regError","两次密码不一致");
            request.getRequestDispatcher("user/register.jsp").forward(request,response);
        }


    }
}
