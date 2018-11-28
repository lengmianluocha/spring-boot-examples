package com.example.jdbc.dao;

import com.example.jdbc.domain.UserInfo;

import java.util.List;

public interface UserInfoDao {

    int add(UserInfo userInfo);

    int update(UserInfo userInfo);

    int delete(int id);

    UserInfo getUserInfoById(int id);

    List<UserInfo> searchUserInfo();
}
