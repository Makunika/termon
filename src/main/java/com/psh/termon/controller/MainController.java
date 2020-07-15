package com.psh.termon.controller;

import com.psh.termon.repos.CourseRep;
import com.psh.termon.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final CourseService courseService;

    public MainController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "hello";
    }
}
