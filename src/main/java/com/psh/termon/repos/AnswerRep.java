package com.psh.termon.repos;


import com.psh.termon.data.Answer;
import com.psh.termon.data.Lesson;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRep extends CrudRepository<Answer, Long> {
    Answer findByLesson(Lesson lesson);
    Answer findByLesson_Id(Long id);
}
