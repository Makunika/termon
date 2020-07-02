package com.psh.termon.controller;

import com.psh.termon.data.User;
import com.psh.termon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class Greeting {

    @Autowired
    private UserService userService;

    @GetMapping
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                           Map<String, Object> model) {
        model.put("name", name);
        model.put("title", "hello");
        model.put("users", userService.getAll());
        return "gretting";
    }

    @GetMapping("/gre")
    public String main(Map<String, Object> model) {
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String login, @RequestParam String password,
                      Map<String, Object> model) {
        userService.addUser(new User(login, password));
        model.put("title", "hello");
        model.put("name", "World");
        model.put("users", userService.getAll());
        return "gretting";
    }

}
