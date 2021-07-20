package com.spring.database;
import org.springframework.stereotype.Component;

@Component
public class Member {
    private int id  = 0;
    //member name
    private String name = "";
    //member password
    private String password = "";
    //最後登陸時間
    private String last_login = "";
    //每日平均工作時間 周時/日時
    private String average_time = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLast_login() { return last_login; }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public String getAverage_time() {
        return average_time;
    }

    public void setAverage_time(String average_time) {
        this.average_time = average_time;
    }
}
