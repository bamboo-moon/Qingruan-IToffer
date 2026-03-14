package dao;

import bean.Admin;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public  class AdminDao {
    //登录dao
    public static Admin adminLogin(String adminLogin,String adminPwd){
        Connection conn  = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
           conn = DBUtil.getConn();
           String sql = "select *   from admininfo where admin_login=? and admin_pwd=?";
           psta = conn.prepareStatement(sql);
           psta.setString(1,adminLogin);
           psta.setString(2,adminPwd);
           resultSet = psta.executeQuery();
           if(resultSet.next()){
               Admin admin = new Admin();
               admin.setAdminId(resultSet.getInt("admin_id"));
               admin.setAdminPwd(resultSet.getString("admin_pwd"));
               admin.setAdminName(resultSet.getString("admin_name"));
               admin.setAdminLogin(resultSet.getString("admin_login"));
               admin.setAdminEmail(resultSet.getString("admin_email"));
               admin.setAdminRole(resultSet.getString("admin_role"));
               admin.setAdminStatus(resultSet.getInt("admin_status"));
                return admin;
           }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return null;
    }
    //添加admin信息
    public static int addAdmin(String adminLogin,String adminPwd,String adminName,String adminEmail,
                        String adminRole,int adminStatus){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
            conn = DBUtil.getConn();
            String sql = "insert into admininfo(admin_login,admin_pwd,admin_name,admin_email," +
                    "admin_role,admin_status) values(?,?,?,?,?,?)";
            psta = conn.prepareStatement(sql);
            psta.setString(1,adminLogin);
            psta.setString(2,adminPwd);
            psta.setString(3,adminName);
            psta.setString(4,adminEmail);
            psta.setString(5,adminRole);
            psta.setInt(6,adminStatus);
            int num = psta.executeUpdate();
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeUpdate(psta,conn);
        }
        return 0;
    }
    //获取所有用户信息
    public static List<Admin> getAllAdmin(){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql ="select *   from admininfo";
            psta = conn.prepareStatement(sql);
            resultSet = psta.executeQuery();
            List<Admin> adminList = new ArrayList<>();
            while(resultSet.next()){
                Admin admin = new Admin();
                admin.setAdminId(resultSet.getInt("admin_id"));
                admin.setAdminPwd(resultSet.getString("admin_pwd"));
                admin.setAdminName(resultSet.getString("admin_name"));
                admin.setAdminLogin(resultSet.getString("admin_login"));
                admin.setAdminEmail(resultSet.getString("admin_email"));
                admin.setAdminRole(resultSet.getString("admin_role"));
                admin.setAdminStatus(resultSet.getInt("admin_status"));
                adminList.add(admin);
            }
            return adminList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return null;
    }
    //修改用户状态
    public static int updateAdminStatus(int adminStatus,int adminId){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
            conn = DBUtil.getConn();
            String sql ="update admininfo  set admin_status = ? where admin_id=?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,adminStatus);
            psta.setInt(2,adminId);
            int num = psta.executeUpdate();
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeUpdate(psta,conn);
        }
        return 0;
    }
    //数据回显
    public static Admin getAdminById(int adminId){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql = "select *  from  admininfo where admin_id=?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,adminId);
            resultSet = psta.executeQuery();
            if(resultSet.next()){
                Admin admin = new Admin();
                admin.setAdminId(resultSet.getInt("admin_id"));
                admin.setAdminPwd(resultSet.getString("admin_pwd"));
                admin.setAdminName(resultSet.getString("admin_name"));
                admin.setAdminLogin(resultSet.getString("admin_login"));
                admin.setAdminEmail(resultSet.getString("admin_email"));
                admin.setAdminRole(resultSet.getString("admin_role"));
                admin.setAdminStatus(resultSet.getInt("admin_status"));
                return admin;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return null;
    }
    //修改
    public static int updateAdmin(Admin admin){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
            conn = DBUtil.getConn();
            String sql = "update  admininfo  set  admin_login=?,admin_name=?,admin_pwd=?,admin_email =?,admin_role=? where  admin_id=?";
            psta = conn.prepareStatement(sql);
            psta.setString(1,admin.getAdminLogin());
            psta.setString(2,admin.getAdminName());
            psta.setString(3,admin.getAdminPwd());
            psta.setString(4,admin.getAdminEmail());
            psta.setString(5,admin.getAdminRole());
            psta.setInt(6,admin.getAdminId());
            int num = psta.executeUpdate();
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeUpdate(psta,conn);
        }
        return 0;
    }
}
