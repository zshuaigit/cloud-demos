package com.zshuai.client;

import com.zshuai.config.FeignConfig;
import com.zshuai.po.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by zshuai
 *
 * @Date :2020/3/31 4:56 PM
 * @Version 1.0
 **/
@FeignClient(value = "user-service",fallback = UserClientFallback.class,configuration = FeignConfig.class)
public interface UserClient {

    @GetMapping("user/{id}")
    User queryById(@PathVariable("id") Long id);


}
