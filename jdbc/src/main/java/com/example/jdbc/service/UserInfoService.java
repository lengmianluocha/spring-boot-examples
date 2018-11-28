package com.example.jdbc.service;

import com.example.jdbc.domain.UserInfo;

import java.util.List;

public interface UserInfoService {

    int add(UserInfo userInfo);

    int update(UserInfo userInfo);

    int delete(int id);

    UserInfo getUserInfoById(int id);

    List<UserInfo> searchUserInfo();
}
