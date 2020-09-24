package com.example.demo.controller;

import com.example.demo.form.User;
import lombok.Builder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class index {

    @GetMapping(name = "/")
    public String index(){
        return "index";
    }

    @GetMapping(value ="/create")
    public String create(Model model){
        User user = new User();
        user.setFirstName("Alexandre");
        user.setLastName("La Biunda");
        model.addAttribute("user", user);

        return "create_user";
    }

    @PostMapping(value ="/create")
    public String createUser(Model model, User user){
        model.addAttribute("user", user);
        return "create_user";
    }
}
