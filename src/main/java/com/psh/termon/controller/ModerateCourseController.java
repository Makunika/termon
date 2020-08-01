package com.psh.termon.controller;


import com.psh.termon.data.Course;
import com.psh.termon.data.Module;
import com.psh.termon.data.User;
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

    @GetMapping("/edit/{course_id}")
    public String editCourse(@AuthenticationPrincipal User user,
                             @PathVariable Long course_id,
                             Model model) {
        model.addAttribute("user", user);
        model.addAttribute("course", courseService.findById(course_id));
        return "editCourse";
    }

    @PostMapping("/edit/{course_id}")
    public String addLesson(@AuthenticationPrincipal User user,
                            @PathVariable Long course_id,
                            @RequestParam String name,
                            @RequestParam String text,
                            Model model) {
        Course course = courseService.findById(course_id);
        if (course == null) {
            return "redirect:/user/edit/" + course_id;
        }
        Module module = new Module(course, name, text, null);
        moduleService.addModule(module);
        courseService.addModuleToCourse(course, module);
        return "redirect:/user/edit/" + course_id;
    }

    @GetMapping("modules/{id}/lessons")
    public String editLesson(@PathVariable Integer id) {
        return "editLessons";
    }
}
