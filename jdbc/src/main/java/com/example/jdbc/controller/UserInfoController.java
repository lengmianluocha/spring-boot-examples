package com.example.jdbc.controller;

import com.example.jdbc.domain.UserInfo;
import com.example.jdbc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value="/userinfoList",method = RequestMethod.GET)
    public Map searchUserInfoList() {
        List<UserInfo> userInfoList = userInfoService.searchUserInfo();
        Map<String, Object> param = new HashMap<>();
        param.put("total", userInfoList.size());
        param.put("rows", userInfoList);
        return param;
    }

    @RequestMapping(value = "/{userId:\\d+}",method = RequestMethod.GET)
    public UserInfo getUserInfo(@PathVariable int userId) {
        UserInfo userInfo = userInfoService.getUserInfoById(userId);
        return userInfo;
    }

    @RequestMapping("/add")
    public String add(@RequestParam("userName") String userName,@RequestParam("pwd") String pwd) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setPassword(pwd);
        userInfoService.add(userInfo);
        return "success";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("id") int id,@RequestParam("userName") String userName,@RequestParam("pwd") String pwd) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setUserName(userName);
        userInfo.setPassword(pwd);
        userInfoService.update(userInfo);
        return "success";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        userInfoService.delete(id);
        return "success";
    }
}
