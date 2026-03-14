package dao;

import bean.Exjob;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExJobDao {
    public static int addExjob(String exjob_loc,String exjob_time,String exjob_name,int user_id){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
            conn = DBUtil.getConn();
            String sql = "insert into exjob(exjob_loc,exjob_time,exjob_name,user_id)" +
                    "values(?,?,?,?)";
            psta = conn.prepareStatement(sql);
            psta.setString(1,exjob_loc);
            psta.setString(2,exjob_time);
            psta.setString(3,exjob_name);
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

    public static List<Exjob> findExjobByUserId(int user_id){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql= "select  *   from  exjob  where user_id =?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,user_id);
            resultSet = psta.executeQuery();
            List<Exjob> exjobList = new ArrayList<>();
            while(resultSet.next()){
                Exjob exjob=new Exjob(
                        resultSet.getInt("exjob_id"),
                        resultSet.getString("exjob_loc") ,
                        resultSet.getString("exjob_time") ,
                        resultSet.getString("exjob_name") ,
                        resultSet.getInt("user_id")
                );
                exjobList.add(exjob);
            }
            return exjobList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return null;
    }

    public static Exjob findExjobByExjobId(int exjob_id){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql= "select  *   from  exjob  where exjob_id =?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,exjob_id);
            resultSet = psta.executeQuery();
            Exjob exjob=null;
            while(resultSet.next()){
                exjob = new Exjob(
                        resultSet.getInt("exjob_id"),
                        resultSet.getString("exjob_loc") ,
                        resultSet.getString("exjob_time") ,
                        resultSet.getString("exjob_name") ,
                        resultSet.getInt("user_id")
                );
            }
            return exjob;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return null;
    }
    public static int updateExjob(int exjob_id,String exjob_loc,String exjob_time,String exjob_name){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
            conn = DBUtil.getConn();
            String sql = "update exjob set exjob_loc=?,exjob_time=?,exjob_name=?" +
                    "where exjob_id=?";
            psta = conn.prepareStatement(sql);
            psta.setString(1,exjob_loc);
            psta.setString(2,exjob_time);
            psta.setString(3,exjob_name);
            psta.setInt(4,exjob_id);
            int num = psta.executeUpdate();
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeUpdate(psta,conn);
        }
        return 0;
    }

    public static int deleteExjob(int exjob_id){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
            conn = DBUtil.getConn();
            String sql = "delete from exjob where exjob_id=?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,exjob_id);
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
