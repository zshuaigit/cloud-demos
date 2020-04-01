package com.zshuai.user.service;

import com.zshuai.user.mapper.UserMapper;
import com.zshuai.user.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zshuai
 *
 * @Date :2020/3/31 2:26 PM
 * @Version 1.0
 **/
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User queryById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }
}
