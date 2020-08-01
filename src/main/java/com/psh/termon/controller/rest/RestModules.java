package com.psh.termon.controller.rest;


import com.fasterxml.jackson.annotation.JsonView;
import com.psh.termon.data.Course;
import com.psh.termon.data.Lesson;
import com.psh.termon.data.Module;
import com.psh.termon.data.User;
import com.psh.termon.service.CourseService;
import com.psh.termon.service.ModuleService;
import com.psh.termon.views.Views;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping("/api/courses/{courseId}/modules")
public class RestModules {

    private final ModuleService moduleService;
    private final CourseService courseService;

    public RestModules(ModuleService moduleService, CourseService courseService) {
        this.moduleService = moduleService;
        this.courseService = courseService;
    }

    @GetMapping
    @JsonView(Views.ModuleLessons.class)
    public ResponseEntity<List<Module>> getModules(@PathVariable Long courseId) {
        List<Module> modules = moduleService.getByCourse_Id(courseId);
        if (modules == null || modules.size() <= 0) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(modules);
        }
    }

    @PostMapping
    @JsonView(Views.ModuleLessons.class)
    public ResponseEntity<Module> createModule(@PathVariable Integer courseId,
                                               @RequestBody Module module,
                                               @AuthenticationPrincipal User user) {

        Course course = courseService.findById(courseId.longValue());
        module.setCourse(course);
        module.setAbout("Напишите здесь about");
        moduleService.addModule(module);
        courseService.addModuleToCourse(course, module);
        return ResponseEntity.ok().body(module);
    }

    @PutMapping("{id}")
    @JsonView(Views.ModuleLessons.class)
    public ResponseEntity<Module> editModule(@PathVariable Integer courseId,
                                             @PathVariable Integer id,
                                             @RequestBody Module module,
                                             @AuthenticationPrincipal User user) {

        Module moduleDo = moduleService.getById(id);
        moduleDo.setName(module.getName());
        moduleDo.setNumber(module.getNumber());

        return ResponseEntity.ok().body(moduleService.addModule(moduleDo));
    }
}
