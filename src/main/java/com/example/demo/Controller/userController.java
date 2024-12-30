package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.user;
import com.example.demo.Service.userService;

@RestController
@RequestMapping("user")
public class userController {
    
    @Autowired
    private userService usServ;

    @PostMapping("addUser")
    public String addUser(@RequestBody user us){
        return usServ.addUser(us);
    }
}
