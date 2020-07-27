package com.psh.termon.controller.rest;


import com.psh.termon.data.Module;
import com.psh.termon.service.ModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping("/api/courses/{courseId}/modules")
public class RestModules {

    private final ModuleService moduleService;

    public RestModules(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping
    public ResponseEntity<List<Module>> getModules(@PathVariable Long courseId) {
        List<Module> modules = moduleService.getByCourse_Id(courseId);
        if (modules == null || modules.size() <= 0) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(modules);
        }
    }
}
