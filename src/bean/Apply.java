package bean;

public class Apply {
    private Job job;
    private User user;

    private int status;
    private int userjob_id;

    public Apply() {
    }


    public Apply(Job job, User user, int status, int userjob_id) {
        this.job = job;
        this.user = user;
        this.status = status;
        this.userjob_id = userjob_id;
    }

    /**
     * 获取
     * @return job
     */
    public Job getJob() {
        return job;
    }

    /**
     * 设置
     * @param job
     */
    public void setJob(Job job) {
        this.job = job;
    }

    /**
     * 获取
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * 设置
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 获取
     * @return status
     */
    public int getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 获取
     * @return userjob_id
     */
    public int getUserjob_id() {
        return userjob_id;
    }

    /**
     * 设置
     * @param userjob_id
     */
    public void setUserjob_id(int userjob_id) {
        this.userjob_id = userjob_id;
    }

    public String toString() {
        return "Apply{job = " + job + ", user = " + user + ", status = " + status + ", userjob_id = " + userjob_id + "}";
    }
}
