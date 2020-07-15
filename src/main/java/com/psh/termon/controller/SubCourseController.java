package com.psh.termon.controller;


import com.psh.termon.data.Lesson;
import com.psh.termon.data.User;
import com.psh.termon.repos.CourseRep;
import com.psh.termon.repos.LessonRep;
import com.psh.termon.service.CourseService;
import com.psh.termon.service.LessonService;
import com.psh.termon.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/courses")
public class SubCourseController {

    private final LessonService lessonService;


    public SubCourseController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping
    private String allCourses(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        model.addAttribute("user", user);
        model.addAttribute("courses", user.getCourses());
        return "main";
    }
}
