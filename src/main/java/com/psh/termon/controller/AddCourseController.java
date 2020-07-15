package com.psh.termon.controller;


import com.psh.termon.data.Course;
import com.psh.termon.data.User;
import com.psh.termon.repos.CourseRep;
import com.psh.termon.service.CourseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user/add_course")
@PreAuthorize("hasAnyAuthority('MODER', 'ADMIN')")
public class AddCourseController {

    private final CourseService courseService;

    public AddCourseController(CourseService courseService) {
        this.courseService = courseService;
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
        courseService.addCourse(course);
        return "redirect:/user";
    }
}
