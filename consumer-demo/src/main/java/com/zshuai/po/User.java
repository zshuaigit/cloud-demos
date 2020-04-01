package com.zshuai.po;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by zshuai
 *
 * @Date :2020/3/31 2:41 PM
 * @Version 1.0
 **/
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    // 用户名
    private String userName;

    // 密码
    private String password;

    // 姓名
    private String name;

    // 年龄
    private Integer age;

    // 性别，1男性，2女性
    private Integer sex;


}
