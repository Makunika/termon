package com.psh.termon.controller;


import com.psh.termon.data.Course;
import com.psh.termon.data.User;
import com.psh.termon.repos.CourseRep;
import com.psh.termon.repos.UserRep;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/course")
public class CourseController {

    private final CourseRep courseRep;
    private final UserRep userRep;

    public CourseController(CourseRep courseRep, UserRep userRep) {
        this.courseRep = courseRep;
        this.userRep = userRep;
    }

    @GetMapping("{courseId}")
    public String showCourse(
            @PathVariable Long courseId,
            Model model) {
        Course course = courseRep.findById(courseId).orElse(null);
        model.addAttribute("course", course);
        return "course";
    }

    @PostMapping("{courseId}")
    public String subOrUnsubCourse(
            @PathVariable Long courseId,
            @AuthenticationPrincipal User user,
            @RequestParam String type) {
        Course course = courseRep.findById(courseId).orElse(null);
        if (course != null) {
            if (type.equals("sub")) {
                user.getCourses().add(course);
                course.getUser().add(user);
            } else {
                user.getCourses().remove(
                        user.getCourses()
                                .stream()
                                .filter(course1 -> course1.getId().equals(course.getId()))
                                .findFirst()
                                .orElse(null)
                );
                course.getUser().remove(
                        course.getUser()
                                .stream()
                                .filter(user1 -> user1.getId().equals(user.getId()))
                                .findFirst()
                                .orElse(null)
                );
            }
            userRep.save(user);
            courseRep.save(course);
        }
        return "redirect:/course/" + courseId;
    }
}
