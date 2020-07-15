package com.psh.termon.controller;



import com.psh.termon.data.User;
import com.psh.termon.data.Role;
import com.psh.termon.repos.UserRep;
import com.psh.termon.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model)
    {
        if (userService.findByLogin(user.getLogin()) != null) {
            model.addAttribute("error", "User exist");
            return "registration";
        }
        userService.addUser(user);
        return "redirect:/login";
    }
}
