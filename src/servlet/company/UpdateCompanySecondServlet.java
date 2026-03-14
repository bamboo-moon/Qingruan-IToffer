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

@MultipartConfig
@WebServlet("/updatecompanysecond")
public class UpdateCompanySecondServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        int com_id= Integer.parseInt(request.getParameter("com_id"));
        String companyName = request.getParameter("companyName");
        String companyLoc = request.getParameter("companyLoc");
        String companySize = request.getParameter("companySize");
        String companyType = request.getParameter("companyType");
        String companyDesc = request.getParameter("companyDesc");
        String companyStatus = request.getParameter("companyStatus");
        Company company = CompanyDao.getCompanyById(com_id);
        String companyImg = company.getCompanyImg();


        Part part = request.getPart("uploadImg");
        String oldFileName = part.getSubmittedFileName();
        //需要判断是否和当前头像一样
        String fileName;
        if(oldFileName.isEmpty()){
            fileName=companyImg;
        }
        else{
            String typeName = oldFileName.substring(oldFileName.lastIndexOf("."));
            String uuid = UUID.randomUUID().toString();
            fileName = uuid+typeName;
            String path = request.getServletContext().getRealPath("/");
            part.write(path+"/upload/"+fileName);
        }


        if(companyName.isEmpty()||companyLoc.isEmpty()||companySize.isEmpty()||companyType.isEmpty()||companyDesc.isEmpty()||companyStatus.isEmpty()||fileName.isEmpty()){
            request.setAttribute("updateError","所填内容不能为空");
            request.getRequestDispatcher("updatecompanyfirst").forward(request,response);
        }else{
            CompanyDao.updateCompany(com_id,companyName,companyLoc,companySize,companyType,companyDesc,companyStatus,fileName);

                response.sendRedirect("findAllCompany");

        }
    }
}
