package com.insurance.VehicleInsurance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "loginView"; // This looks for loginView.html in /templates
    }

}