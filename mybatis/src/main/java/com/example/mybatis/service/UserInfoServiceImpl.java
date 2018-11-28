package com.example.mybatis.service;

import com.example.mybatis.dao.UserInfoMapper;
import com.example.mybatis.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int add(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    @Override
    public int update(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public int delete(int id) {
        return userInfoMapper.deleteByPrimaryKey(Long.parseLong(id+""));
    }

    @Override
    public UserInfo getUserInfoById(int id) {
        return userInfoMapper.selectByPrimaryKey(Long.parseLong(id+""));
    }

    @Override
    public List<UserInfo> searchUserInfo() {
        return null;
    }
}
