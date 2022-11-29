package com.example.myspring.service;


import com.example.myspring.entity.UserBean;
import com.example.myspring.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

@Service
public class UserService {
    //将dao层属性注入service层
    @Resource
    private UserMapper userMapper;


    public UserBean LoginIn(String name, String password) {
        return userMapper.getInfo(name,DigestUtils.md5DigestAsHex(password.getBytes()));
    }

    public UserBean EloginIn(String email){
        return userMapper.getInfoByEmail(email);
    }


    public void Insert(String name,String password,String email){
        userMapper.saveInfo(name, DigestUtils.md5DigestAsHex(password.getBytes()),email);
    }
}