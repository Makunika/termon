package com.psh.termon.service;

import com.psh.termon.data.Lesson;
import com.psh.termon.exception.NotFoundException;
import com.psh.termon.repos.LessonRep;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

    private final LessonRep lessonRep;

    public LessonService(LessonRep lessonRep) {
        this.lessonRep = lessonRep;
    }

    public Lesson findById(Long lesson_id) {
        return lessonRep.findById(lesson_id).orElseThrow(NotFoundException::new);
    }

    public Lesson addLesson(Lesson lesson) {
        return lessonRep.save(lesson);
    }
}
