package com.psh.termon.controller;

import com.psh.termon.data.Course;
import com.psh.termon.data.Lesson;
import com.psh.termon.data.Module;
import com.psh.termon.service.CourseService;
import com.psh.termon.service.LessonService;
import com.psh.termon.service.ModuleService;
import com.psh.termon.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;

@Controller
public class MainController {

    private final CourseService courseService;
    private final ModuleService moduleService;
    private final LessonService lessonService;
    private final UserService userService;

    private final boolean test = true;

    public MainController(CourseService courseService, ModuleService moduleService, LessonService lessonService, UserService userService) {
        this.courseService = courseService;
        this.moduleService = moduleService;
        this.lessonService = lessonService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String main(Model model) {

        if (test) {
            Course course = courseService.findById(38L);
            Module module = new Module(course, "Препроцессор", "О модуле!", new HashSet<>(), 1);

            module = moduleService.addModule(module);
            course = courseService.addCourse(course);

            Lesson lesson1 = new Lesson(module, "# Header", "Урок 1", 1l, userService.findByLogin("admin"));
            Lesson lesson2 = new Lesson(module, "# Header 2", "Урок 2", 2l, userService.findByLogin("admin"));
            lessonService.addLesson(lesson1);
            lessonService.addLesson(lesson2);
            moduleService.addLessonToModule(module, lesson1);
            moduleService.addLessonToModule(module, lesson2);
        }




        model.addAttribute("courses", courseService.findAll());
        return "hello";
    }
}
