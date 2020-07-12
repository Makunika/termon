package com.psh.termon.controller;



import com.psh.termon.data.User;
import com.psh.termon.data.UserRole;
import com.psh.termon.repos.UserRep;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class AuthController {

    private final UserRep userRep;

    public AuthController(UserRep userRep) {
        this.userRep = userRep;
    }


    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model)
    {
        if (userRep.findByLogin(user.getLogin()) != null) {
            model.addAttribute("error", "User exist");
            return "registration";
        }
        user.setRoles(Collections.singleton(UserRole.USER));
        userRep.save(user);
        return "redirect:/login";
    }
}
