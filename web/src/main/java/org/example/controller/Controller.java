package org.example.controller;

import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/web")
@RestController
public class Controller {
    @Autowired
    private RestTemplate restTemplate;
    /* * * 购票方法     */
    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public String order(){
        // 模拟当前用户
        int id = 2;
        User user = restTemplate.getForObject("http://localhost:9101/user/" + id, User.class);
        if (user != null) {
            System.out.println(user.getUsername() + "==正在购票...");
            return "购票成功";
        } else {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "用户未找到");
        }
    }
}
