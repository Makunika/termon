package com.psh.termon.data;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;

    private String name;

    @Column(length = 3000)
    private String about;

    @OneToMany
    private Set<Lesson> lessons;

    public Module(Course course, String name, String about, Set<Lesson> lessons) {
        this.course = course;
        this.name = name;
        this.about = about;
        this.lessons = lessons;
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
}
