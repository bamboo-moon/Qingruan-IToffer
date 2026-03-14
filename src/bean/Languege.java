package bean;

public class Languege {
    private int lan_id;
    private String lan_name;
    private String lan_listen;
    private String lan_write;
    private String lan_level;
    private int user_id;

    public Languege() {
    }

    public Languege(int lan_id, String lan_name, String lan_listen, String lan_write, String lan_level, int user_id) {
        this.lan_id = lan_id;
        this.lan_name = lan_name;
        this.lan_listen = lan_listen;
        this.lan_write = lan_write;
        this.lan_level = lan_level;
        this.user_id = user_id;
    }

    /**
     * 获取
     * @return lan_id
     */
    public int getLan_id() {
        return lan_id;
    }

    /**
     * 设置
     * @param lan_id
     */
    public void setLan_id(int lan_id) {
        this.lan_id = lan_id;
    }

    /**
     * 获取
     * @return lan_name
     */
    public String getLan_name() {
        return lan_name;
    }

    /**
     * 设置
     * @param lan_name
     */
    public void setLan_name(String lan_name) {
        this.lan_name = lan_name;
    }

    /**
     * 获取
     * @return lan_listen
     */
    public String getLan_listen() {
        return lan_listen;
    }

    /**
     * 设置
     * @param lan_listen
     */
    public void setLan_listen(String lan_listen) {
        this.lan_listen = lan_listen;
    }

    /**
     * 获取
     * @return lan_write
     */
    public String getLan_write() {
        return lan_write;
    }

    /**
     * 设置
     * @param lan_write
     */
    public void setLan_write(String lan_write) {
        this.lan_write = lan_write;
    }

    /**
     * 获取
     * @return lan_level
     */
    public String getLan_level() {
        return lan_level;
    }

    /**
     * 设置
     * @param lan_level
     */
    public void setLan_level(String lan_level) {
        this.lan_level = lan_level;
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
        return "Languege{lan_id = " + lan_id + ", lan_name = " + lan_name + ", lan_listen = " + lan_listen + ", lan_write = " + lan_write + ", lan_level = " + lan_level + ", user_id = " + user_id + "}";
    }
}
