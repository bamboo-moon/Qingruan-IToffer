package servlet.admin;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/codePath")
public class CodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用工具包 生成我们想要的验证码
        //设置为图像模式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //生成一个验证码是4个符号  宽180px  高200px  20根干扰线
        //TW52
        ValidateCode validateCode = new ValidateCode(100,20,4,20);
        //验证码对象  有验证码  还要输出到页面去
        System.out.println("后台得到的验证码："+validateCode.getCode());
        //为了方便登录处理器对比验证码  需要把生成的验证码存在session中  用于对比
        request.getSession().setAttribute("validateCode",validateCode.getCode());
        //把验证码输出
        validateCode.write(response.getOutputStream());


    }
}
