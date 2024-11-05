package org.example.client;

import org.example.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** * 用户微服务远程接口
 * 三个注意事项：
 * 1）使用@FeignClient，声明需要调用的微服务
 * 2) 检查@RequesetMapping注解，value值（路径）是否完整
 * 3) @PathVariable注解的value不能省略的
 */
@FeignClient(value = "user")
public interface UserController {
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable(value = "id") Integer id);
}
