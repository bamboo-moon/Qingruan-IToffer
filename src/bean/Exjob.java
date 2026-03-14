package bean;

public class Exjob {
    private int exjob_id;
    private String exjob_loc;
    private String exjob_time;
    private String exjob_name;
    private int user_id;


    public Exjob() {
    }

    public Exjob(int exjob_id, String exjob_loc, String exjob_time, String exjob_name, int user_id) {
        this.exjob_id = exjob_id;
        this.exjob_loc = exjob_loc;
        this.exjob_time = exjob_time;
        this.exjob_name = exjob_name;
        this.user_id = user_id;
    }

    /**
     * 获取
     * @return exjob_id
     */
    public int getExjob_id() {
        return exjob_id;
    }

    /**
     * 设置
     * @param exjob_id
     */
    public void setExjob_id(int exjob_id) {
        this.exjob_id = exjob_id;
    }

    /**
     * 获取
     * @return exjob_loc
     */
    public String getExjob_loc() {
        return exjob_loc;
    }

    /**
     * 设置
     * @param exjob_loc
     */
    public void setExjob_loc(String exjob_loc) {
        this.exjob_loc = exjob_loc;
    }

    /**
     * 获取
     * @return exjob_time
     */
    public String getExjob_time() {
        return exjob_time;
    }

    /**
     * 设置
     * @param exjob_time
     */
    public void setExjob_time(String exjob_time) {
        this.exjob_time = exjob_time;
    }

    /**
     * 获取
     * @return exjob_name
     */
    public String getExjob_name() {
        return exjob_name;
    }

    /**
     * 设置
     * @param exjob_name
     */
    public void setExjob_name(String exjob_name) {
        this.exjob_name = exjob_name;
    }

    /**
     * 获取
     * @return user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * 设置
     * @param user_id
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String toString() {
        return "Exjob{exjob_id = " + exjob_id + ", exjob_loc = " + exjob_loc + ", exjob_time = " + exjob_time + ", exjob_name = " + exjob_name + ", user_id = " + user_id + "}";
    }
}
