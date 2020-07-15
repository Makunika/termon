package com.psh.termon.service;

import com.psh.termon.data.Answer;
import com.psh.termon.data.Lesson;
import com.psh.termon.exception.NotFoundException;
import com.psh.termon.repos.AnswerRep;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    private final AnswerRep answerRep;

    public AnswerService(AnswerRep answerRep) {
        this.answerRep = answerRep;
    }

    public Answer findById(Long id) {
        return answerRep.findById(id).orElseThrow(NotFoundException::new);
    }

    public Answer addAnswer(Answer answer) {
        return answerRep.save(answer);
    }

    public void deleteAnswer(Answer answer) {
        answerRep.deleteById(answer.getId());
    }

    public Answer findByLesson(Lesson lesson) {
        return answerRep.findByLesson(lesson);
    }

    public Answer findByLesson_Id(Long id) {
        return answerRep.findByLesson_Id(id);
    }

    public Answer editAnswer(String ans, Answer answer) {
        answer.setAnswer(ans);
        return answerRep.save(answer);
    }
}
