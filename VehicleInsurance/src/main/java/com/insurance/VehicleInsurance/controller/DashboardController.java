package com.insurance.VehicleInsurance.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            System.out.println("Authenticated User: " + auth.getName()); // Debugging
            model.addAttribute("username", auth.getName());
        } else {
            System.out.println("No authenticated user found.");
            model.addAttribute("username", "Guest");
        }

        return "dashboard";
    }
}
