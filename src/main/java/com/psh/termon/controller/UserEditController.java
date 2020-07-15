package com.psh.termon.controller;


import com.psh.termon.data.User;
import com.psh.termon.data.Role;
import com.psh.termon.repos.UserRep;
import com.psh.termon.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/users_edit")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserEditController {

    private final UserService userService;

    public UserEditController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String editList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "usersList";
    }

    @GetMapping("{userId}")
    public String editUserGet(@PathVariable Long userId,
                           Model model) {
        model.addAttribute("user", userService.findById(userId));
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping("{userId}")
    public String editUserPost(@PathVariable Long userId,
                               @RequestParam String username,
                               @RequestParam Map<String, String> form) {
        User user = userService.findById(userId);

        if (user != null) {
            userService.editUser(user, username, form.keySet());
        }
        return "redirect:/users_edit";
    }

}
