package com.pnb.springsecurityusernameandpassword.controllers;

import com.pnb.springsecurityusernameandpassword.model.User;
import com.pnb.springsecurityusernameandpassword.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String root(){
        return "Root page!";
    }

    @GetMapping("/home")
    public String home(){
        return "Welcome my friend!";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Welcome my administrator!";
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        return this.userService.save(user);
    }
}
