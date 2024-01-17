package com.kartikey.APICURD.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping()
public class HomeController {
    @GetMapping("/name")
    public String getLoggedUser(Authentication a){
        return "Welcome "+a.getName();
    }
    @GetMapping("/auth")
    public Principal user(Principal user) {
        return user;
    }

    @GetMapping("/resource")
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<String, Object>();

        model.put("id", UUID.randomUUID().toString());
        model.put("status", true);

        return model;
    }

    @GetMapping("/userid")
    public User getUserId() {
        // Retrieve the currently authenticated user from the SecurityContext
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
