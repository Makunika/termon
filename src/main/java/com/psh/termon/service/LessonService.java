package com.psh.termon.service;

import com.psh.termon.data.Lesson;
import com.psh.termon.exception.NotFoundException;
import com.psh.termon.repos.LessonRep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    private final LessonRep lessonRep;

    public LessonService(LessonRep lessonRep) {
        this.lessonRep = lessonRep;
    }

    public Lesson findById(Long lesson_id) {
        return lessonRep.findById(lesson_id).orElseThrow(NotFoundException::new);
    }

    public List<Lesson> getByModule_Id(int id) {
        return lessonRep.findByModule_Id((long) id);
    }

    public Lesson addLesson(Lesson lesson) {
        return lessonRep.save(lesson);
    }
}
