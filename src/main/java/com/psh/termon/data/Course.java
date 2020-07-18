package com.psh.termon.data;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User author;

    private String name;

    @OneToMany
    private Set<Lesson> lessons;

    private Integer size;

    @Column(length = 500)
    private String headerImgName;

    @Column(length = 4000)
    private String about;

    public Course() {
    }

    public Course(User author, String name, Set<Lesson> lessons, String headerImgName, String about) {
        this.author = author;
        this.name = name;
        this.lessons = lessons;
        this.headerImgName = headerImgName;
        this.about = about;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getHeaderImgName() {
        return headerImgName;
    }

    public void setHeaderImgName(String headerImgName) {
        this.headerImgName = headerImgName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
