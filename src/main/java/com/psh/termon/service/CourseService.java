package com.psh.termon.service;

import com.psh.termon.data.Course;
import com.psh.termon.data.Lesson;
import com.psh.termon.data.User;
import com.psh.termon.exception.NotFoundException;
import com.psh.termon.repos.CourseRep;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CourseService {

    private final CourseRep courseRep;

    public CourseService(CourseRep courseRep) {
        this.courseRep = courseRep;
    }

    public Set<Course> findByAuthor_Id(Long id) {
        return  courseRep.findByAuthor_Id(id);
    }

    public Course findById(Long course_id) {
        return courseRep.findById(course_id).orElseThrow(NotFoundException::new);
    }

    public Course addLessonToCourse(Course course, Lesson lesson) {
        course.getLessons().add(lesson);
        return courseRep.save(course);
    }

    public Iterable<Course> findAll() {
        return courseRep.findAll();
    }

    public Course addCourse(Course course) {
        course.setSize(0);
        return courseRep.save(course);
    }
}
