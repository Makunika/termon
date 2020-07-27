package com.psh.termon.data;

import com.fasterxml.jackson.annotation.JsonView;
import com.psh.termon.views.Views;

import javax.persistence.*;

@Entity
public class Answer {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @JsonView(Views.Id.class)
    private Long id;

    @JsonView(Views.MainInformation.class)
    private String answer;

    @OneToOne
    @JsonView(Views.MainInformation.class)
    private Lesson lesson;

    public Answer() {
    }

    public Answer(String answer, Lesson lesson) {
        this.answer = answer;
        this.lesson = lesson;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
