package bean;

public class Job {
    private int jobId;
    private String jobName;
    private String jobSal;
    private String jobLoc;
    //招聘人数
    private String jobCount;
    //学历
    private String jobDegree;
    //专业
    private String jobSubject;
    //职位描述
    private String jobDesc;
    //任职要求
    private String jobDetail;
    //招聘状态
    private int jobStatus;
    //工作经验
    private String jobYear;
    private int companyId;
    //添加一个新属性  不跟数据库对象
    private String comName;

    private int userHasJob;
    private int userJobStatus;

    public Job() {
    }

    public Job(int jobId, String jobName, String jobSal, String jobLoc, String jobCount, String jobDegree, String jobSubject, String jobDesc, String jobDetail, int jobStatus, String jobYear, int companyId, String comName) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobSal = jobSal;
        this.jobLoc = jobLoc;
        this.jobCount = jobCount;
        this.jobDegree = jobDegree;
        this.jobSubject = jobSubject;
        this.jobDesc = jobDesc;
        this.jobDetail = jobDetail;
        this.jobStatus = jobStatus;
        this.jobYear = jobYear;
        this.companyId = companyId;
        this.comName = comName;
    }

    public Job(int jobId, String jobName, String jobSal, String jobLoc, String jobCount, String jobDegree, String jobSubject, String jobDesc, String jobDetail, int jobStatus, String jobYear, int companyId, String comName, int userHasJob) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobSal = jobSal;
        this.jobLoc = jobLoc;
        this.jobCount = jobCount;
        this.jobDegree = jobDegree;
        this.jobSubject = jobSubject;
        this.jobDesc = jobDesc;
        this.jobDetail = jobDetail;
        this.jobStatus = jobStatus;
        this.jobYear = jobYear;
        this.companyId = companyId;
        this.comName = comName;
        this.userHasJob = userHasJob;
    }

    public Job(int jobId, String jobName, String jobSal, String jobLoc, String jobCount, String jobDegree, String jobSubject, String jobDesc, String jobDetail, int jobStatus, String jobYear, int companyId, String comName, int userHasJob, int userJobStatus) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobSal = jobSal;
        this.jobLoc = jobLoc;
        this.jobCount = jobCount;
        this.jobDegree = jobDegree;
        this.jobSubject = jobSubject;
        this.jobDesc = jobDesc;
        this.jobDetail = jobDetail;
        this.jobStatus = jobStatus;
        this.jobYear = jobYear;
        this.companyId = companyId;
        this.comName = comName;
        this.userHasJob = userHasJob;
        this.userJobStatus = userJobStatus;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobSal() {
        return jobSal;
    }

    public void setJobSal(String jobSal) {
        this.jobSal = jobSal;
    }

    public String getJobLoc() {
        return jobLoc;
    }

    public void setJobLoc(String jobLoc) {
        this.jobLoc = jobLoc;
    }

    public String getJobCount() {
        return jobCount;
    }

    public void setJobCount(String jobCount) {
        this.jobCount = jobCount;
    }

    public String getJobDegree() {
        return jobDegree;
    }

    public void setJobDegree(String jobDegree) {
        this.jobDegree = jobDegree;
    }

    public String getJobSubject() {
        return jobSubject;
    }

    public void setJobSubject(String jobSubject) {
        this.jobSubject = jobSubject;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobDetail() {
        return jobDetail;
    }

    public void setJobDetail(String jobDetail) {
        this.jobDetail = jobDetail;
    }

    public int getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(int jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobYear() {
        return jobYear;
    }

    public void setJobYear(String jobYear) {
        this.jobYear = jobYear;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String toString() {
        return "Job{jobId = " + jobId + ", jobName = " + jobName + ", jobSal = " + jobSal + ", jobLoc = " + jobLoc + ", jobCount = " + jobCount + ", jobDegree = " + jobDegree + ", jobSubject = " + jobSubject + ", jobDesc = " + jobDesc + ", jobDetail = " + jobDetail + ", jobStatus = " + jobStatus + ", jobYear = " + jobYear + ", companyId = " + companyId + ", comName = " + comName + "}";
    }

    /**
     * 获取
     * @return userHasJob
     */
    public int getUserHasJob() {
        return userHasJob;
    }

    /**
     * 设置
     * @param userHasJob
     */
    public void setUserHasJob(int userHasJob) {
        this.userHasJob = userHasJob;
    }

    /**
     * 获取
     * @return userJobStatus
     */
    public int getUserJobStatus() {
        return userJobStatus;
    }

    /**
     * 设置
     * @param userJobStatus
     */
    public void setUserJobStatus(int userJobStatus) {
        this.userJobStatus = userJobStatus;
    }
}
