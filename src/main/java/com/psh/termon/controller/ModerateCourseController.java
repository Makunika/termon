package com.psh.termon.controller;


import com.psh.termon.data.Course;
import com.psh.termon.data.Module;
import com.psh.termon.data.User;
import com.psh.termon.exception.NotFoundException;
import com.psh.termon.service.CourseService;
import com.psh.termon.service.ModuleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAnyAuthority('ADMIN','MODER')")
public class ModerateCourseController {

    private final CourseService courseService;
    private final ModuleService moduleService;

    public ModerateCourseController(CourseService courseService, ModuleService moduleService) {
        this.courseService = courseService;
        this.moduleService = moduleService;
    }

    @GetMapping
    public String userProfile(@AuthenticationPrincipal User user,
                              Model model) {
        model.addAttribute("user", user);
        model.addAttribute("courses", courseService.findByAuthor_Id(user.getId()));
        return "userProfile";
    }

    @GetMapping("/edit/courses/{course_id}/modules")
    public String editCourse(@AuthenticationPrincipal User user,
                             @PathVariable Integer course_id,
                             Model model) {
        if (!courseService.findById(course_id.longValue()).getAuthor().getId().equals(user.getId())) {
            throw new NotFoundException();
        }
        model.addAttribute("course", courseService.findById(course_id.longValue()));
        return "editCourse";
    }

    @GetMapping("/edit/courses/{course_id}/modules/{module_id}/lessons")
    public String editModule(@AuthenticationPrincipal User user,
                             @PathVariable Long course_id,
                             Model model) {
        if (!courseService.findById(course_id).getAuthor().getId().equals(user.getId())) {
            throw new NotFoundException();
        }
        return "editLessons";
    }
}
