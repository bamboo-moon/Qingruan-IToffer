package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConn(){
        try{
            String url ="jdbc:mysql://localhost:3306/itoffer?serverTimezone=UTC&useSSL=false";
            Connection conn = DriverManager.getConnection(url,"root","minecraft233");
            return conn;
        }catch (Exception e){
            e.printStackTrace();
        }
       return null;
    }
    //关闭
    public static void closeUpdate(PreparedStatement psta,Connection conn){
        if(psta!=null){
            try {
                psta.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        if(conn!=null){
            try{
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void closeQuery(ResultSet resultSet,PreparedStatement psta, Connection conn){
        if(resultSet!=null){
            try {
               resultSet.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(psta!=null){
            try {
                psta.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        if(conn!=null){
            try{
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
