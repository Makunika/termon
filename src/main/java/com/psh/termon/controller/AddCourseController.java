package com.psh.termon.controller;


import com.psh.termon.data.Course;
import com.psh.termon.data.User;
import com.psh.termon.service.CourseService;
import com.psh.termon.service.StorageService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/user/add_course")
@PreAuthorize("hasAnyAuthority('MODER', 'ADMIN')")
public class AddCourseController {

    private final CourseService courseService;
    private final StorageService storageService;

    public AddCourseController(CourseService courseService, StorageService storageService) {
        this.courseService = courseService;
        this.storageService = storageService;
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
                            @RequestParam String aboutCourse,
                            @RequestParam("file") MultipartFile headerPicter,
                            Model model) throws IOException {

        File resultFile = storageService.storage(headerPicter);
        Course course = new Course(user, nameCourse, null, resultFile.getName(), aboutCourse);
        courseService.addCourse(course);
        return "redirect:/user";
    }
}
