package com.example.TestProject.controller;

import com.example.TestProject.entity.User;
import com.example.TestProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public void createUser(@RequestBody User user)
    {
        System.out.println("Creating user : "+user);
        user.setPassWord(new BCryptPasswordEncoder().encode(user.getPassWord()));
        System.out.println("Creating user : "+user);
        userService.saveUser(user);
    }

    @GetMapping("/login")
    public void loginMe()
    {
        System.out.println("Logged in correctly");
    }

}
