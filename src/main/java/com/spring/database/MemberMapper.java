package com.spring.database;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//MemberDTO
public class MemberMapper implements RowMapper<Member> {
    // TODO model mapper
    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
        Member member = new Member();
        member.setId(rs.getInt("ID"));
        member.setName(rs.getString("NAME"));
        member.setPassword(rs.getString("PASSWORD"));
        member.setLast_login(rs.getString("LAST_LOGIN"));
        return member;
    }
}
