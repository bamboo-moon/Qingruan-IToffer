package bean;

public class Edu {
    private int edu_id;
    private String edu_college;
    private String edu_time;
    private String edu_zhuanye;
    private int user_id;


    public Edu() {
    }

    public Edu(int edu_id, String edu_college, String edu_time, String edu_zhuanye, int user_id) {
        this.edu_id = edu_id;
        this.edu_college = edu_college;
        this.edu_time = edu_time;
        this.edu_zhuanye = edu_zhuanye;
        this.user_id = user_id;
    }

    /**
     * 获取
     * @return edu_id
     */
    public int getEdu_id() {
        return edu_id;
    }

    /**
     * 设置
     * @param edu_id
     */
    public void setEdu_id(int edu_id) {
        this.edu_id = edu_id;
    }

    /**
     * 获取
     * @return edu_college
     */
    public String getEdu_college() {
        return edu_college;
    }

    /**
     * 设置
     * @param edu_college
     */
    public void setEdu_college(String edu_college) {
        this.edu_college = edu_college;
    }

    /**
     * 获取
     * @return edu_time
     */
    public String getEdu_time() {
        return edu_time;
    }

    /**
     * 设置
     * @param edu_time
     */
    public void setEdu_time(String edu_time) {
        this.edu_time = edu_time;
    }

    /**
     * 获取
     * @return edu_zhuanye
     */
    public String getEdu_zhuanye() {
        return edu_zhuanye;
    }

    /**
     * 设置
     * @param edu_zhuanye
     */
    public void setEdu_zhuanye(String edu_zhuanye) {
        this.edu_zhuanye = edu_zhuanye;
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
        return "Edu{edu_id = " + edu_id + ", edu_college = " + edu_college + ", edu_time = " + edu_time + ", edu_zhuanye = " + edu_zhuanye + ", user_id = " + user_id + "}";
    }
}
