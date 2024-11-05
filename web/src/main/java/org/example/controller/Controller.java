package org.example.controller;

import org.example.client.UserController;
import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/web")
@RestController
public class Controller {
//    @Autowired
//    private RestTemplate restTemplate;
//    @Autowired
//    private DiscoveryClient discoveryClient;
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private UserController userController;
    /* * * 购票方法     */
    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public String order() {
        // 模拟当前用户
        int id = 2;
//        List<ServiceInstance> instances = discoveryClient.getInstances("user");

//        ServiceInstance serviceInstance = loadBalancerClient.choose("user");

//        User user = restTemplate.getForObject(
//                "http://user/user/" + id,
//                User.class
//        );

        User user = userController.findById(id);

        if (user != null) {
            System.out.println(user.getUsername() + "==正在购票...");
            return "购票成功";
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "用户未找到");
        }
    }
}
