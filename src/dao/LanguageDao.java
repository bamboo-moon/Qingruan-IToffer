package dao;

import bean.Languege;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LanguageDao {
    public static List<Languege> findLanByUserId(int user_id){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql= "select  *   from  language  where user_id =?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,user_id);
            resultSet = psta.executeQuery();
            List<Languege> lanList = new ArrayList<>();
            while(resultSet.next()){
                Languege languege=new Languege(
                        resultSet.getInt("lan_id"),
                        resultSet.getString("lan_name"),
                        resultSet.getString("lan_listen"),
                        resultSet.getString("lan_write"),
                        resultSet.getString("lan_level"),
                        resultSet.getInt("user_id")
                );
                lanList.add(languege);
            }
            return lanList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return null;
    }
    public static Languege findLanByLanId(int lan_id){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql= "select  *   from  language  where lan_id =?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,lan_id);
            resultSet = psta.executeQuery();
            Languege lan=null;
            while(resultSet.next()){
                lan=new Languege(
                        resultSet.getInt("lan_id"),
                        resultSet.getString("lan_name"),
                        resultSet.getString("lan_listen"),
                        resultSet.getString("lan_write"),
                        resultSet.getString("lan_level"),
                        resultSet.getInt("user_id")
                );
            }
            return lan;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return null;
    }

    public static int addLan(String lan_name,String lan_listen,String lan_write,String lan_level,int user_id){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
            conn = DBUtil.getConn();
            String sql = "insert into language (lan_name,lan_listen,lan_write,lan_level,user_id)" +
                    "values(?,?,?,?,?)";
            psta = conn.prepareStatement(sql);
            psta.setString(1,lan_name);
            psta.setString(2,lan_listen);
            psta.setString(3,lan_write);
            psta.setString(4,lan_level);
            psta.setInt(5,user_id);
            int num = psta.executeUpdate();
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeUpdate(psta,conn);
        }
        return 0;
    }

    public static int updateLan(int lan_id,String lan_name,String lan_listen,String lan_write,String lan_level){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
            conn = DBUtil.getConn();
            String sql = "update language set lan_name=?,lan_listen=?,lan_write=?,lan_level=?" +
                    "where lan_id=?";
            psta = conn.prepareStatement(sql);
            psta.setString(1,lan_name);
            psta.setString(2,lan_listen);
            psta.setString(3,lan_write);
            psta.setString(4,lan_level);
            psta.setInt(5,lan_id);
            int num = psta.executeUpdate();
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeUpdate(psta,conn);
        }
        return 0;
    }

    public static int deleteLan(int lan_id){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
            conn = DBUtil.getConn();
            String sql = "delete from language where lan_id=?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,lan_id);
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
