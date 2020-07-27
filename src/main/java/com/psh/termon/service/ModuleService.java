package com.psh.termon.service;

import com.psh.termon.data.Course;
import com.psh.termon.data.Lesson;
import com.psh.termon.data.Module;
import com.psh.termon.repos.ModuleRep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    private final ModuleRep moduleRep;

    public ModuleService(ModuleRep moduleRep) {
        this.moduleRep = moduleRep;
    }

    public List<Module> getByCourse_Id(Long courseId) {
        return moduleRep.findByCourse_Id(courseId);
    }

    public Module addLessonToModule(Module module, Lesson lesson) {
        module.getLessons().add(lesson);
        return moduleRep.save(module);
    }

    public Module addModule(Module module) {
        return moduleRep.save(module);
    }

}
