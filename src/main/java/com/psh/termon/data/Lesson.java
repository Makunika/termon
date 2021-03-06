package com.psh.termon.data;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.psh.termon.views.Views;

import javax.persistence.*;

@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.Id.class)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Module module;

    @Column(length = 3000)
    @JsonView(Views.FullLesson.class)
    private String text;

    @JsonView(Views.IdName.class)
    private String name;

    @JsonView(Views.IdName.class)
    private Long number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonView(Views.MainInformation.class)
    private User autor;

    public Lesson() {
    }

    public Lesson(Module module, String text, String name, Long number, User autor) {
        this.module = module;
        this.text = text;
        this.name = name;
        this.number = number;
        this.autor = autor;
    }

    public Lesson(String text, String name, Long number) {
        this.text = text;
        this.name = name;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAutor() {
        return autor;
    }

    public void setAutor(User autor) {
        this.autor = autor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
