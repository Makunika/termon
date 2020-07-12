package com.psh.termon.controller;

import com.psh.termon.repos.CourseRep;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    private final CourseRep courseRep;

    public HelloController(CourseRep courseRep) {
        this.courseRep = courseRep;
    }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("courses", courseRep.findAll());
        return "hello";
    }
}
