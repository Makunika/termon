package com.psh.termon.controller;


import com.psh.termon.data.Course;
import com.psh.termon.data.User;
import com.psh.termon.repos.CourseRep;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user/add_course")
public class AddCourseController {

    private final CourseRep courseRep;

    public AddCourseController(CourseRep courseRep) {
        this.courseRep = courseRep;
    }

    @GetMapping
    public String newCourse(@AuthenticationPrincipal User user,
                            Model model) {
        model.addAttribute("user", user);
        return "addCourse";
    }

    @PostMapping
    public String addCourse(@AuthenticationPrincipal User user,
                            @RequestParam String nameCourse,
                            Model model) {
        Course course = new Course(user, nameCourse, null);
        course.setSize(0);
        courseRep.save(course);
        return "redirect:/user";
    }
}
