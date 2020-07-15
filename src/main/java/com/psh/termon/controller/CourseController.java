package com.psh.termon.controller;


import com.psh.termon.data.Course;
import com.psh.termon.data.User;
import com.psh.termon.service.CourseService;
import com.psh.termon.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final UserService userService;

    public CourseController(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
    }

    @GetMapping("{courseId}")
    public String showCourse(
            @PathVariable Long courseId,
            Model model) {
        model.addAttribute("course", courseService.findById(courseId));
        return "course";
    }

    @PostMapping("{courseId}")
    public String subOrUnsubCourse(
            @PathVariable Long courseId,
            @AuthenticationPrincipal User user,
            @RequestParam String type) {
        Course course = courseService.findById(courseId);
        if (course != null) {
            if (type.equals("sub")) {
                userService.subCourse(user, course);
            } else {
                userService.unSubCourse(user, course);
            }
        }
        return "redirect:/course/" + courseId;
    }
}
