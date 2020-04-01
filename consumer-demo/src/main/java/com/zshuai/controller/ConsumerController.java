package com.zshuai.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.zshuai.client.UserClient;
import com.zshuai.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zshuai
 *
 * @Date :2020/3/31 2:42 PM
 * @Version 1.0
 **/
@RestController
@RequestMapping("consumer")
//@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

//    @Autowired
//    DiscoveryClient discoveryClient;
//
//    @GetMapping("/{id}")
//    public User queryBuId(@PathVariable("id") Long id){
//        //根据服务ID获取实例
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        //从实例中取出IP和端口
//        ServiceInstance serviceInstance = instances.get(0);
//        String url = "http://"+serviceInstance.getHost()
//                +":"+serviceInstance.getPort()+"/user/"+id;
//        System.out.println(url);
//
//        //String url = "http://localhost:8081/user/" + id;
//        return this.restTemplate.getForObject(url, User.class);
//    }

    //复杂ribbon使用
//    @Autowired
//    RibbonLoadBalancerClient client;
//    @GetMapping("/{id}")
//    public User queryBuId(@PathVariable("id") Long id){
//        //默认是轮询
//        ServiceInstance instance = client.choose("user-service");
//        String url = "http://"+instance.getHost()
//                +":"+instance.getPort()+"/user/"+id;
//        return this.restTemplate.getForObject(url, User.class);
//    }

    //简单ribbon使用。需要在启动类别的restTemplate添加 LoadBalanced注解
//    @GetMapping("/{id}")
//    public User queryBuId(@PathVariable("id") Long id){
//        String url = "http://user-service/user/"+id;
//        System.out.println(url);
//        return this.restTemplate.getForObject(url, User.class);
//    }

    //失败容错
//    @GetMapping("/{id}")
//    @HystrixCommand(fallbackMethod = "queryUserByIdFallback")
//    public String queryBuId(@PathVariable("id") Long id){
//        String url = "http://user-service/user/"+id;
//        return this.restTemplate.getForObject(url, String.class);
//    }
//
//    public String queryUserByIdFallback(Long id){
//        return "抱歉，网络出现异常，请稍后重试！";
//    }


//    @GetMapping("/{id}")
//    @HystrixCommand
//    public String queryBuId(@PathVariable("id") Long id){
//        String url = "http://user-service/user/"+id;
//        return this.restTemplate.getForObject(url, String.class);
//    }


    //使用feign进行查询，不在需要RestTemplate。启动类等都可删除掉
    @Autowired
    UserClient userCliennt;
    @GetMapping("/{id}")
    public User queryBuId(@PathVariable("id") Long id){
        return userCliennt.queryById(id);
    }

    public String  defaultFallback(){
        return "抱歉，网络出现异常，请稍后重试！";
    }






}
