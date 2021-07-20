package com.spring.database;

import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;

@Repository
public interface MemberDAO {
    //初始化 database resource
    public void setDataSource(DataSource ds);
    //create member data
    public void create(String name,String password);
    //get member data
    public Member getMemberID(String name);
    //抓取多筆資料時用
    public List<Member> listMembers(String name);
    //delete data
    public void delete(int id);
    //update password
    public void update_password(int id, String pw);
    //update login date
    public void set_login_date(int id);
}
