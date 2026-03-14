package bean;
//用户信息
public class User {
    private int userId;
    private  String userCode;
    private String userPwd;
    private String userName;
    private String userSex;
    private String userBirthday;
    private String userEmail;
    private String userWork;
    private String userYear;
    private String userImg;
    private String userPhone;

    public User() {
    }

    public User(int userId, String userCode, String userPwd, String userName, String userSex, String userBirthday, String userEmail, String userWork, String userYear, String userImg, String userPhone) {
        this.userId = userId;
        this.userCode = userCode;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userSex = userSex;
        this.userBirthday = userBirthday;
        this.userEmail = userEmail;
        this.userWork = userWork;
        this.userYear = userYear;
        this.userImg = userImg;
        this.userPhone = userPhone;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserWork() {
        return userWork;
    }

    public void setUserWork(String userWork) {
        this.userWork = userWork;
    }

    public String getUserYear() {
        return userYear;
    }

    public void setUserYear(String userYear) {
        this.userYear = userYear;
    }


    public String toString() {
        return "User{userId = " + userId + ", userCode = " + userCode + ", userPwd = " + userPwd + ", userName = " + userName + ", userSex = " + userSex + ", userBirthday = " + userBirthday + ", userEmail = " + userEmail + ", userWork = " + userWork + ", userYear = " + userYear + ", userImg = " + userImg + ", userPhone = " + userPhone + "}";
    }
}
