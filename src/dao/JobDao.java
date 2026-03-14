package dao;

import bean.Apply;
import bean.Job;
import bean.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public  class JobDao {
    //添加职位
    public static int addJob(String jobName,String jobSal,String jobLoc,String jobCount,String jobDegree,
                      String jobSubject,String jobDesc,String jobDetail,int jobStatus,String jobYear,int companyId){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
           conn = DBUtil.getConn();
           String sql = "insert into job(job_name,job_sal,job_loc,job_count,job_degree,job_subject,job_desc,job_detail,job_status,job_year,company_id)" +
                   "values(?,?,?,?,?,?,?,?,?,?,?)";
           psta = conn.prepareStatement(sql);
           psta.setString(1,jobName);
           psta.setString(2,jobSal);
           psta.setString(3,jobLoc);
           psta.setString(4,jobCount);
           psta.setString(5,jobDegree);
           psta.setString(6,jobSubject);
           psta.setString(7,jobDesc);
           psta.setString(8,jobDetail);
           psta.setInt(9,jobStatus);
           psta.setString(10,jobYear);
           psta.setInt(11,companyId);
           int num = psta.executeUpdate();
           return num;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeUpdate(psta,conn);
        }
        return 0;
    }
    //查询职位 并显示所属企业
    public static List<Job> findJob(){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
           conn = DBUtil.getConn();
           String sql= "select job_id,job_name,job_count,job_loc,job_status,job.company_id,company_name " +
                   "from  job left  join company on job.company_id =company.company_id";
           psta = conn.prepareStatement(sql);
           resultSet = psta.executeQuery();
           List<Job> jobList = new ArrayList<>();
           while(resultSet.next()){
               Job job = new Job();
               job.setJobCount(resultSet.getString("job_count"));
               job.setJobId(resultSet.getInt("job_id"));
               job.setJobName(resultSet.getString("job_name"));
               job.setJobLoc(resultSet.getString("job_loc"));
               job.setCompanyId(resultSet.getInt("company_id"));
               job.setJobStatus(resultSet.getInt("job_status"));
               job.setComName(resultSet.getString("company_name"));
               jobList.add(job);
           }
           return jobList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return null;
    }
    //根据企业id  查询对应的职位信息
    public static List<Job> findJobByCompanyId(int companyId){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql= "select  *   from  job  where company_id =?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,companyId);
            resultSet = psta.executeQuery();
            List<Job> jobList = new ArrayList<>();
            while(resultSet.next()){
                Job job = new Job();
                job.setJobCount(resultSet.getString("job_count"));
                job.setJobId(resultSet.getInt("job_id"));
                job.setJobName(resultSet.getString("job_name"));
                job.setJobLoc(resultSet.getString("job_loc"));
                job.setCompanyId(resultSet.getInt("company_id"));
                job.setJobStatus(resultSet.getInt("job_status"));
                job.setJobDegree(resultSet.getString("job_degree"));
                job.setJobDetail(resultSet.getString("job_detail"));
                job.setJobDesc(resultSet.getString("job_desc"));
                job.setJobSal(resultSet.getString("job_sal"));
                job.setJobYear(resultSet.getString("job_year"));
                job.setJobSubject(resultSet.getString("job_subject"));
                jobList.add(job);
            }
            return jobList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return null;
    }
    //根据职位id  查询职位具体信息
    public static Job findJobByJobId(int jobId){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql= "select  *   from  job  where job_id =?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,jobId);
            resultSet = psta.executeQuery();
            while(resultSet.next()){
                Job job = new Job();
                job.setJobCount(resultSet.getString("job_count"));
                job.setJobId(resultSet.getInt("job_id"));
                job.setJobName(resultSet.getString("job_name"));
                job.setJobLoc(resultSet.getString("job_loc"));
                job.setCompanyId(resultSet.getInt("company_id"));
                job.setJobStatus(resultSet.getInt("job_status"));
                job.setJobDegree(resultSet.getString("job_degree"));
                job.setJobDetail(resultSet.getString("job_detail"));
                job.setJobDesc(resultSet.getString("job_desc"));
                job.setJobSal(resultSet.getString("job_sal"));
                job.setJobYear(resultSet.getString("job_year"));
                job.setJobSubject(resultSet.getString("job_subject"));
                return job;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return null;
    }

    public static  List<Job> findJobByJobnameAndComID(int comID,String jobName){
        Connection conn = null;
        PreparedStatement psta = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConn();
            String sql= "select  *   from  job  where company_id=? and job_name=?";
            psta = conn.prepareStatement(sql);
            psta.setInt(1,comID);
            psta.setString(2,jobName);
            resultSet = psta.executeQuery();
            List<Job> jobList = new ArrayList<>();
            while(resultSet.next()){
                Job job = new Job();
                job.setJobCount(resultSet.getString("job_count"));
                job.setJobId(resultSet.getInt("job_id"));
                job.setJobName(resultSet.getString("job_name"));
                job.setJobLoc(resultSet.getString("job_loc"));
                job.setCompanyId(resultSet.getInt("company_id"));
                job.setJobStatus(resultSet.getInt("job_status"));
                job.setJobDegree(resultSet.getString("job_degree"));
                job.setJobDetail(resultSet.getString("job_detail"));
                job.setJobDesc(resultSet.getString("job_desc"));
                job.setJobSal(resultSet.getString("job_sal"));
                job.setJobYear(resultSet.getString("job_year"));
                job.setJobSubject(resultSet.getString("job_subject"));
                jobList.add(job);
            }
            return jobList;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeQuery(resultSet,psta,conn);
        }
        return null;
    }

    public static int updateJob(int job_id,String jobName,String jobSal,String jobLoc,String jobCount,String jobDegree,
                             String jobSubject,String jobDesc,String jobDetail,int jobStatus,String jobYear){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
            conn = DBUtil.getConn();
            String sql = "update job set job_name=?,job_sal=?,job_loc=?,job_count=?" +
                    ",job_degree=?,job_subject=?,job_desc=?,job_detail=?,job_status=?" +
                    ",job_year=? where job_id=?";

            psta = conn.prepareStatement(sql);

            psta.setString(1,jobName);
            psta.setString(2,jobSal);
            psta.setString(3,jobLoc);
            psta.setString(4,jobCount);
            psta.setString(5,jobDegree);
            psta.setString(6,jobSubject);
            psta.setString(7,jobDesc);
            psta.setString(8,jobDetail);
            psta.setInt(9,jobStatus);
            psta.setString(10,jobYear);
            psta.setInt(11,job_id);

            int num = psta.executeUpdate();
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeUpdate(psta,conn);
        }
        return 0;
    }
    public static int deleteJob(int job_id){
        Connection conn = null;
        PreparedStatement psta = null;
        try {
            conn = DBUtil.getConn();
            String sql = "delete from job where job_id=?";
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
