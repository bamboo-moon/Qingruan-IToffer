package servlet.company;

import bean.Company;
import dao.CompanyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/saveCompany")
//处理器要接受multipart/form-data  启动文件上传解析器
@MultipartConfig //当前处理器使用文件上传解析器解析数据  并取值
public class AddCompanyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收企业信息参数
        request.setCharacterEncoding("utf-8");
        String companyName = request.getParameter("companyName");
        String companyLoc = request.getParameter("companyLoc");
        String companySize = request.getParameter("companySize");
        String companyType = request.getParameter("companyType");
        String status = request.getParameter("companyStatus");
        int companyStatus = Integer.parseInt(status);

        String companyDesc = request.getParameter("companyDesc");
        //先完成文件上传
        //1 使用流 接收请求中的文件数据
        Part part = request.getPart("uploadImg");
        //2 part接收了请求中的文件  并提供的输入输出函数
        //输出路径是服务器所在路径
        String realPath = request.getServletContext().getRealPath("/");//获取根路径的函数
        System.out.println("realPath = " + realPath);
        //E://qdhy/itoffer/upload/1.jpg
        //文件性质（得到文件的原后缀名） 和文件名称 （不能重复）
        //3  源文件的名字
        String oldFileName = part.getSubmittedFileName();
        System.out.println("oldFileName = " + oldFileName);//1.jpg   love.txt.jpg
        String typeName = oldFileName.substring(oldFileName.lastIndexOf("."));
        //4 生成唯一名字  时间戳  uuid（在服务器中产生一个64为随机 数字和字母的组合  保证唯一）
        String uuid = UUID.randomUUID().toString();//aweds98uyh
        System.out.println("uuid = " + uuid);
        //5  组合一个新文件名
        String fileName = uuid+typeName;//aweds98uyh.jpg
        part.write(realPath+"/upload/"+fileName);
        //把企业信息存储到数据库中
        Company company = new Company();
        company.setCompanyType(companyType);
        company.setCompanyStatus(companyStatus);
        company.setCompanySize(companySize);
        company.setCompanyDesc(companyDesc);
        company.setCompanyName(companyName);
        company.setCompanyLoc(companyLoc);
        company.setCompanyImg(fileName);
        int num1 = CompanyDao.addCompany(company);
        if(num1>0){
            response.sendRedirect("findAllCompany");
        }else{
            request.setAttribute("saveError","添加失败");
            request.getRequestDispatcher("admin/page/company/companyAdd.jsp").forward(request,response);
        }

    }
}
