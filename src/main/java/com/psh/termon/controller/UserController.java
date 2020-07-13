package com.psh.termon.controller;


import com.psh.termon.data.Course;
import com.psh.termon.data.Lesson;
import com.psh.termon.data.User;
import com.psh.termon.repos.CourseRep;
import com.psh.termon.repos.LessonRep;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAnyAuthority('ADMIN','MODER')")
public class UserController {

    private final CourseRep courseRep;
    private final LessonRep lessonRep;

    public UserController(CourseRep courseRep, LessonRep lessonRep) {
        this.courseRep = courseRep;
        this.lessonRep = lessonRep;
    }

    @GetMapping
    public String userProfile(@AuthenticationPrincipal User user,
                              Model model) {
        model.addAttribute("user", user);
        model.addAttribute("courses", courseRep.findByAuthor_Id(user.getId()));
        return "userProfile";
    }

    @GetMapping("/edit/{course_id}")
    public String editCourse(@AuthenticationPrincipal User user,
                             @PathVariable String course_id,
                             Model model) {
        model.addAttribute("user", user);

        Optional<Course> course = courseRep.findById(Long.parseLong(course_id));

        model.addAttribute("course", course.orElse(null));

        return "editCourse";
    }

    @PostMapping("/edit/{course_id}")
    public String addLesson(@AuthenticationPrincipal User user,
                            @PathVariable String course_id,
                            @RequestParam String name,
                            @RequestParam String text,
                            Model model) {
        Course course = courseRep.findById(Long.parseLong(course_id)).orElse(null);
        if (course == null) {
            return "redirect:/user/edit/" + course_id;
        }


        Lesson lesson = new Lesson(course, text, user);
        lesson.setName(name);
        course.getLessons().add(lesson);

        //if (course.getLessons() == null) {
        //    Set<Lesson> lessonSet = new HashSet<>();
        //    lessonSet.add(lesson);
        //    course.setLessons(lessonSet);
        //} else {
        //    course1.getLessons().add(lesson);
        //    course1.setLessons(course1.getLessons());
        //}
        lessonRep.save(lesson);
        courseRep.save(course);
        return "redirect:/user/edit/" + course_id;
    }
}
