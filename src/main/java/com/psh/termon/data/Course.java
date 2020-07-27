package com.psh.termon.data;

import javax.persistence.*;
import java.util.Collection;
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
    private Set<Module> modules;

    private Integer size;

    @Column(length = 500)
    private String headerImgName;

    @Column(length = 4000)
    private String about;

    @ManyToMany
    Collection<User> subs;

    public Course() {
    }

    public Course(User author, String name, Set<Module> modules, String headerImgName, String about) {
        this.author = author;
        this.name = name;
        this.modules = modules;
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

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
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

    public Collection<User> getSubs() {
        return subs;
    }

    public void setSubs(Collection<User> subs) {
        this.subs = subs;
    }
}
