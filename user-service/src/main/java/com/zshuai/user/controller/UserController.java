package com.zshuai.user.controller;

import com.zshuai.user.po.User;
import com.zshuai.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by zshuai
 *
 * @Date :2020/3/31 2:28 PM
 * @Version 1.0
 **/
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id){

        // 为了演示超时现象，我们在这里然线程休眠,时间随机 0~2000毫秒
        try {
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userService.queryById(id);
    }
}
