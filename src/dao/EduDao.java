package dao;

import bean.Edu;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EduDao {
    public static List<Edu> findEduByUserId(int user_id){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql= "select  *   from  edu  where user_id =?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,user_id);
            resultSet = psta.executeQuery();
            List<Edu> eduList = new ArrayList<>();
            while(resultSet.next()){
                Edu edu = new Edu(
                resultSet.getInt("edu_id"),
                resultSet.getString("edu_college") ,
                resultSet.getString("edu_time") ,
                resultSet.getString("edu_zhuanye") ,
                resultSet.getInt("user_id")
                );
                eduList.add(edu);
            }
            return eduList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return null;
    }

    public static Edu findEduByEduId(int edu_id){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql= "select  *   from  edu  where edu_id =?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,edu_id);
            resultSet = psta.executeQuery();
            Edu edu=null;
            while(resultSet.next()){
                edu = new Edu(
                        resultSet.getInt("edu_id"),
                        resultSet.getString("edu_college") ,
                        resultSet.getString("edu_time") ,
                        resultSet.getString("edu_zhuanye") ,
                        resultSet.getInt("user_id")
                );
            }
            return edu;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return null;
    }


    public static int addEdu(String edu_college,String edu_time,String edu_zhuanye,int user_id){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
            conn = DBUtil.getConn();
            String sql = "insert into edu(edu_college,edu_time,edu_zhuanye,user_id)" +
                    "values(?,?,?,?)";
            psta = conn.prepareStatement(sql);
            psta.setString(1,edu_college);
            psta.setString(2,edu_time);
            psta.setString(3,edu_zhuanye);
            psta.setInt(4,user_id);
            int num = psta.executeUpdate();
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeUpdate(psta,conn);
        }
        return 0;
    }

    public static int updateEdu(int edu_id,String edu_college,String edu_time,String edu_zhuanye){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
            conn = DBUtil.getConn();
            String sql = "update edu set edu_college=?,edu_time=?,edu_zhuanye=?" +
                    "where edu_id=?";
            psta = conn.prepareStatement(sql);
            psta.setString(1,edu_college);
            psta.setString(2,edu_time);
            psta.setString(3,edu_zhuanye);
            psta.setInt(4,edu_id);
            int num = psta.executeUpdate();
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeUpdate(psta,conn);
        }
        return 0;
    }

    public static int deleteEdu(int edu_id){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
            conn = DBUtil.getConn();
            String sql = "delete from edu where edu_id=?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,edu_id);
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
