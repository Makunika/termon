package com.psh.termon.controller;


import com.psh.termon.data.User;
import com.psh.termon.data.Role;
import com.psh.termon.repos.UserRep;
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

    private final UserRep userRep;

    public UserEditController(UserRep userRep) {
        this.userRep = userRep;
    }


    @GetMapping
    public String editList(Model model) {
        model.addAttribute("users", userRep.findAll());
        return "usersList";
    }

    @GetMapping("{userId}")
    public String editUser(@PathVariable Long userId,
                           Model model) {
        Optional<User> user = userRep.findById(userId);

        model.addAttribute("user", user.orElse(null));
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping("{userId}")
    public String editUserPost(@PathVariable Long userId,
                               @RequestParam String username,
                               @RequestParam Map<String, String> form) {
        User user = userRep.findById(userId).orElse(null);

        if (user != null) {
            user.setLogin(username);

            Set<String> roles = Arrays.stream(Role.values())
                    .map(Role::name)
                    .collect(Collectors.toSet());

            user.getRoles().clear();

            for (String key : form.keySet()) {
                if (roles.contains(key)) {
                    user.getRoles().add(Role.valueOf(key));
                }
            }

            if (user.getRoles().isEmpty()) user.getRoles().add(Role.USER);

            userRep.save(user);
        }
        return "redirect:/users_edit";
    }

}
