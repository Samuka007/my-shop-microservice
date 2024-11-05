package org.example.controller;

import org.example.pojo.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*** 用户Controller */
@RequestMapping("/user")
@RestController   // @RestController=@RequestMapping + @ResponseBody
//@Api(description = "用户控制器")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 查询所有用户
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable Integer id){
        System.out.println("用户微服务11111");
        return userService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestBody User user) {
        userService.add(user);
        return "添加成功";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String update(@RequestBody User user, @PathVariable Integer id) {
        //设置id
        user.setId(id);
        userService.update(user);
        return "修改成功";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
        return "删除成功";
    }
}

