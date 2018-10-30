package com.alex.websocketdemo.uiservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sign_up")
public class SignUpController {

    @GetMapping
    public String getSignUpPage() {
        return "sign_up/index";
    }
}
