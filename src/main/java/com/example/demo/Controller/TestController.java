package com.example.demo.Controller;

import com.example.demo.Domain.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wanglei
 * @date 2020/10/20 11:24 上午
 * @File : TestController.java
 */
@Controller
public class TestController {
    @Autowired
    UserService userService;
    @RequestMapping("/est")
    public void test(){
        final User user = userService.findById(1);
        System.out.println(user.getId());

    }
}
