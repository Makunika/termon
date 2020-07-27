package com.psh.termon.repos;

import com.psh.termon.data.Course;
import com.psh.termon.data.Lesson;
import com.psh.termon.data.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonRep extends CrudRepository<Lesson, Long> {

    List<Lesson> findByModule_Id(Long id);
}
