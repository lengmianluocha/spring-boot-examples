package com.example.jdbc.service;

import com.example.jdbc.dao.UserInfoDao;
import com.example.jdbc.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public int add(UserInfo userInfo) {
        return userInfoDao.add(userInfo);
    }

    @Override
    public int update(UserInfo userInfo) {
        return userInfoDao.update(userInfo);
    }

    @Override
    public int delete(int id) {
        return userInfoDao.delete(id);
    }

    @Override
    public UserInfo getUserInfoById(int id) {
        return userInfoDao.getUserInfoById(id);
    }

    @Override
    public List<UserInfo> searchUserInfo() {
        return userInfoDao.searchUserInfo();
    }
}
