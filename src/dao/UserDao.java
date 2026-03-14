package dao;

import bean.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public  class UserDao {
    //登录
    public static User userLogin(String userCode,String userPwd){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql = "select *  from userinfo where user_code=? and user_pwd=?";
            psta = conn.prepareStatement(sql);
            psta.setString(1,userCode);
            psta.setString(2,userPwd);
            resultSet = psta.executeQuery();
            if(resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserCode(resultSet.getString("user_code"));
                user.setUserPwd(resultSet.getString("user_pwd"));
                user.setUserBirthday(resultSet.getString("user_birthday"));
                user.setUserEmail(resultSet.getString("user_email"));
                user.setUserName(resultSet.getString("user_name"));
                user.setUserSex(resultSet.getString("user_sex"));
                user.setUserWork(resultSet.getString("user_work"));
                user.setUserYear(resultSet.getString("user_year"));
                user.setUserImg(resultSet.getString("user_img"));
                user.setUserPhone(resultSet.getString("user_phone"));
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return null;
    }
    //注册
    public static int userReg(String userCode,String userPwd){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
            conn = DBUtil.getConn();
            String sql ="insert into userinfo(user_code,user_pwd) values (?,?)";
            psta = conn.prepareStatement(sql);
            psta.setString(1,userCode);
            psta.setString(2,userPwd);
            int num = psta.executeUpdate();
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeUpdate(psta,conn);
        }
        return 0;
    }
    //验证卡号是否存在
    public static boolean checkUserCode(String userCode){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql = "select *  from userinfo where user_code=?";
            psta = conn.prepareStatement(sql);
            psta.setString(1,userCode);
            resultSet = psta.executeQuery();
            if(resultSet.next()){//卡号能查询到  卡号已存在  不能使用
                return false;
            }else{
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return false;
    }
    //根据用户id查询用户简历信息
    public static User findUserById(int userId){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql = "select *  from userinfo where user_id=?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,userId);
            resultSet = psta.executeQuery();
            if(resultSet.next()){//卡号能查询到  卡号已存在  不能使用
                User user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserCode(resultSet.getString("user_code"));
                user.setUserPwd(resultSet.getString("user_pwd"));
                user.setUserBirthday(resultSet.getString("user_birthday"));
                user.setUserEmail(resultSet.getString("user_email"));
                user.setUserName(resultSet.getString("user_name"));
                user.setUserSex(resultSet.getString("user_sex"));
                user.setUserWork(resultSet.getString("user_work"));
                user.setUserYear(resultSet.getString("user_year"));
                user.setUserImg(resultSet.getString("user_img"));
                user.setUserPhone(resultSet.getString("user_phone"));
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return null;
    }
    //简历添加  在用户的基础上 修改数据
        public static int updateUserInfo(String userName,String userSex,String userBirthday,String userWork,String userYear,String userPhone,String userImg,String userEmail,int userId){
            Connection conn = null;
            PreparedStatement psta = null;
            try {
                conn = DBUtil.getConn();
                String sql = "update userinfo set user_name=?,user_sex=?,user_birthday=?,user_email=?,user_work=?,user_year=?,user_phone=?,user_img=? " +
                "where user_id=?";
                psta = conn.prepareStatement(sql);
                psta.setString(1,userName);
                psta.setString(2,userSex);
                psta.setString(3,userBirthday);
                psta.setString(4,userEmail);
                psta.setString(5,userWork);
                psta.setString(6,userYear);
                psta.setString(7,userPhone);
                psta.setString(8,userImg);
                psta.setInt(9,userId);

                int num = psta.executeUpdate();
                return num;
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                DBUtil.closeUpdate(psta,conn);
            }
            return 0;
        }

    public static List<User> getAllUser(){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet =null;
        try {
            conn = DBUtil.getConn();
            String sql ="select *   from userinfo";
            psta = conn.prepareStatement(sql);
            resultSet = psta.executeQuery();
            List<User> userList = new ArrayList<>();
            while(resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserCode(resultSet.getString("user_code"));
                user.setUserPwd(resultSet.getString("user_pwd"));
                user.setUserBirthday(resultSet.getString("user_birthday"));
                user.setUserEmail(resultSet.getString("user_email"));
                user.setUserName(resultSet.getString("user_name"));
                user.setUserSex(resultSet.getString("user_sex"));
                user.setUserWork(resultSet.getString("user_work"));
                user.setUserYear(resultSet.getString("user_year"));
                user.setUserImg(resultSet.getString("user_img"));
                user.setUserPhone(resultSet.getString("user_phone"));
                userList.add(user);
            }
            return userList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return null;
    }
}
