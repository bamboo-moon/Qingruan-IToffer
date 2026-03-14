package bean;
//企业信息
public class Company {
    //企业编号
    private int companyId;
    //企业名称
    private String companyName;
    //企业位置
    private String companyLoc;
    //企业描述
    private String companyDesc;
    private String companySize;
    private String companyType;
    //企业状态   0 招聘中  1  已结束
    private int companyStatus;

    private String companyImg;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLoc() {
        return companyLoc;
    }

    public void setCompanyLoc(String companyLoc) {
        this.companyLoc = companyLoc;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public int getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(int companyStatus) {
        this.companyStatus = companyStatus;
    }


    public String getCompanyImg() {
        return companyImg;
    }

    public void setCompanyImg(String companyImg) {
        this.companyImg = companyImg;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyLoc='" + companyLoc + '\'' +
                ", companyDesc='" + companyDesc + '\'' +
                ", companySize='" + companySize + '\'' +
                ", companyType='" + companyType + '\'' +
                ", companyStatus='" + companyStatus +'\''+
                ", companyImg='" + companyImg + '\'' +
                '}';
    }
}
