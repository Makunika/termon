package com.psh.termon.controller;


import com.psh.termon.data.Lesson;
import com.psh.termon.data.User;
import com.psh.termon.repos.CourseRep;
import com.psh.termon.repos.LessonRep;
import com.psh.termon.repos.UserRep;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final UserRep userRep;
    private final CourseRep courseRep;
    private final LessonRep lessonRep;


    public CourseController(UserRep userRep, CourseRep courseRep, LessonRep lessonRep) {
        this.userRep = userRep;
        this.courseRep = courseRep;
        this.lessonRep = lessonRep;
    }

    @GetMapping
    private String allCourses(
            @AuthenticationPrincipal User user,
            Model model
    ) {
        model.addAttribute("user", user);
        model.addAttribute("courses", courseRep.findByUser(user));
        return "main";
    }

    @GetMapping("/lessons/{lesson_id}")
    public String courseLesson(@AuthenticationPrincipal User user,
                               @PathVariable String lesson_id,
                               Model model) {
        Optional<Lesson> lesson = lessonRep.findById(Long.parseLong(lesson_id));
        model.addAttribute("lesson", lesson.orElse(null));
        model.addAttribute("user", user);
        return "lesson";
    }
}
