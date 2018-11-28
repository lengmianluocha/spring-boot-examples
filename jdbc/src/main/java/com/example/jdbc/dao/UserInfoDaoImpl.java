package com.example.jdbc.dao;

import com.example.jdbc.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userInfoDao")
public class UserInfoDaoImpl implements UserInfoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(UserInfo userInfo) {
        return jdbcTemplate.update("INSERT INTO userinfo(username,password) VALUES(?,?)", userInfo.getUserName(), userInfo.getPassword());
    }

    @Override
    public int update(UserInfo userInfo) {
        return jdbcTemplate.update("UPDATE userinfo set username=?,password=? where id=?", userInfo.getUserName(), userInfo.getPassword(), userInfo.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE userinfo where id=?", id);
    }

    @Override
    public UserInfo getUserInfoById(int id) {
        List<UserInfo> userInfoList = jdbcTemplate.query("select * from userinfo where id=?", new Object[]{id}, new BeanPropertyRowMapper(UserInfo.class));
        if (userInfoList != null && userInfoList.size() > 0) {
            return userInfoList.get(0);
        }
        return null;
    }

    @Override
    public List<UserInfo> searchUserInfo() {
        List<UserInfo> userInfoList = jdbcTemplate.query("select * from userinfo", new Object[]{}, new BeanPropertyRowMapper(UserInfo.class));
        return userInfoList;
    }
}
