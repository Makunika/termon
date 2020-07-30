package com.psh.termon.controller.rest;


import com.fasterxml.jackson.annotation.JsonView;
import com.psh.termon.data.Lesson;
import com.psh.termon.data.Module;
import com.psh.termon.data.User;
import com.psh.termon.service.LessonService;
import com.psh.termon.service.ModuleService;
import com.psh.termon.views.Views;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping("/api/modules/{moduleId}/lessons")
public class RestLessons {

    private final ModuleService moduleService;
    private final LessonService lessonService;

    public RestLessons(ModuleService moduleService, LessonService lessonService) {
        this.moduleService = moduleService;
        this.lessonService = lessonService;
    }


    @GetMapping
    @JsonView(Views.FullLesson.class)
    public ResponseEntity<List<Lesson>> getLessons(@PathVariable Integer moduleId) {
        //List<Module> modules = moduleService.getByCourse_Id(courseId);
        List<Lesson> lessons = lessonService.getByModule_Id(moduleId);
        if (lessons == null || lessons.size() <= 0) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(lessons);
        }
    }

    @PostMapping
    @JsonView(Views.IdName.class)
    public ResponseEntity<Lesson> createLesson(@PathVariable Integer moduleId,
                                               @RequestBody Lesson lesson,
                                               @AuthenticationPrincipal User user) {
        Module module = moduleService.getById(moduleId);
        lesson.setAutor(user);
        lesson.setModule(module);
        module.getLessons().add(lesson);
        lessonService.addLesson(lesson);
        moduleService.addModule(module);
        return ResponseEntity.ok().body(lesson);
    }

    @PutMapping
    @JsonView(Views.IdName.class)
    public ResponseEntity<Lesson> editLesson(@PathVariable Integer moduleId,
                                             @RequestBody Lesson lesson,
                                             @AuthenticationPrincipal User user) {
        return ResponseEntity.ok().body(lessonService.addLesson(lesson));
    }
}
