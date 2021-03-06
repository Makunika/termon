package com.psh.termon.data;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.psh.termon.views.Views;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.Id.class)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    @JsonView(Views.IdName.class)
    private String name;

    @Column(length = 3000)
    @JsonView(Views.MainInformation.class)
    private String about;

    @OneToMany
    @JsonView(Views.ModuleLessons.class)
    private Set<Lesson> lessons;

    @JsonView(Views.MainInformation.class)
    private Integer number;

    public Module(Course course, String name, String about, Set<Lesson> lessons, Integer number) {
        this.course = course;
        this.name = name;
        this.about = about;
        this.lessons = lessons;
        this.number = number;
    }

    public Module() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
