package bean;

public class Admin {
    private int  adminId;
    private String adminLogin;
    private String adminPwd;
    private String adminName;
    private String adminEmail;
    private String adminRole;
    private int adminStatus;

    public Admin() {
    }

    public Admin(int adminId, String adminLogin, String adminPwd, String adminName, String adminEmail, String adminRole, int adminStatus) {
        this.adminId = adminId;
        this.adminLogin = adminLogin;
        this.adminPwd = adminPwd;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminRole = adminRole;
        this.adminStatus = adminStatus;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminLogin() {
        return adminLogin;
    }

    public void setAdminLogin(String adminLogin) {
        this.adminLogin = adminLogin;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }

    public int getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(int adminStatus) {
        this.adminStatus = adminStatus;
    }

    public String toString() {
        return "Admin{adminId = " + adminId + ", adminLogin = " + adminLogin + ", adminPwd = " + adminPwd + ", adminName = " + adminName + ", adminEmail = " + adminEmail + ", adminRole = " + adminRole + ", adminStatus = " + adminStatus + "}";
    }
}
