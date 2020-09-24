package com.example.demo.controller;

import com.example.demo.form.User;
import lombok.Builder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    public String createUser(Model model, @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return"error";
        }
        model.addAttribute("user", user);
        return "create_user";
    }
}
