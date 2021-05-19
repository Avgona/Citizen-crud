package com.avgona.citizencrud.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login-form")
    public String loginForm(){
        return "authorization/login-form";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "authorization/access-denied";
    }
}
