package dao;

import bean.Apply;
import bean.Job;
import bean.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class UserJobDao {
    public static ArrayList<Integer> findJidByUid(int user_id){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql = "select job_id  from userjob where user_id=?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,user_id);
            resultSet = psta.executeQuery();
            ArrayList<Integer> list=new ArrayList<>();
            while (resultSet.next()){
                list.add( resultSet.getInt("job_id"));
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return null;
    }

    public  static int userHasJob(int user_id,int job_id){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql = "select *  from userjob where user_id=? and job_id=?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,user_id);
            psta.setInt(2,job_id);
            resultSet = psta.executeQuery();
            if(resultSet.next()){
                return 1;
            }
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return 0;
    }

    public static int addJob(int user_id,int job_id){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
            conn = DBUtil.getConn();
            String sql ="insert into userjob(user_id,job_id,status) values (?,?,?)";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,user_id);
            psta.setInt(2,job_id);
            psta.setInt(3,0);
            int num = psta.executeUpdate();
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeUpdate(psta,conn);
        }
        return 0;
    }
    public static int deleteUserJob(int user_id,int job_id){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
            conn = DBUtil.getConn();
            String sql = "delete from userjob where user_id=? and job_id=?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,user_id);
            psta.setInt(2,job_id);

            int num = psta.executeUpdate();
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeUpdate(psta,conn);
        }
        return 0;
    }

    public static int userJobStatus(int user_id,int job_id){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql = "select status  from userjob where user_id=? and job_id=?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,user_id);
            psta.setInt(2,job_id);
            resultSet = psta.executeQuery();
            if(resultSet.next()){
                int status = resultSet.getInt("status");
                return status;
            }
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return 0;
    }

    public static ArrayList<Apply> checkAllApply(){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql= "SELECT  t2.job_id,t2.company_id,t1.userjob_id,t1.user_id,t1.status FROM userjob t1 LEFT JOIN job t2 ON t1.job_id = t2.job_id";
            psta = conn.prepareStatement(sql);
            resultSet = psta.executeQuery();
            ArrayList<Apply> applyList=new ArrayList<>();
            while(resultSet.next()){
                Job job = JobDao.findJobByJobId(resultSet.getInt("job_id"));
                job.setComName(CompanyDao.getCompanyById(resultSet.getInt("company_id")).getCompanyName());
                User user = UserDao.findUserById(resultSet.getInt("user_id"));
                int status=resultSet.getInt("status");
                int userjob_id=resultSet.getInt("userjob_id");
                Apply apply=new Apply(job,user,status,userjob_id);
                applyList.add(apply);
            }
            return applyList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return null;
    }

    public static int updateStatus(int status,int userjob_id){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
            conn = DBUtil.getConn();
            String sql = "update userjob set status=? where userjob_id=?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,status);
            psta.setInt(2,userjob_id);
            int num = psta.executeUpdate();
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeUpdate(psta,conn);
        }
        return 0;
    }

    public static int deleteUserJob(int job_id){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
            conn = DBUtil.getConn();
            String sql = "delete from userjob where job_id=?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,job_id);
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
