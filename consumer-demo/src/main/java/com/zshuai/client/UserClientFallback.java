package com.zshuai.client;

import com.zshuai.po.User;
import org.springframework.stereotype.Component;

/**
 * Created by zshuai
 *
 * @Date :2020/3/31 5:05 PM
 * @Version 1.0
 **/
@Component
public class UserClientFallback implements UserClient {
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("用户查询出现异常！");
        return user;
    }

}
