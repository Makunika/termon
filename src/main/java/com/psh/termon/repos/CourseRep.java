package com.psh.termon.repos;

import com.psh.termon.data.Course;
import com.psh.termon.data.User;
import org.springframework.data.repository.CrudRepository;


import java.util.Set;

public interface CourseRep extends CrudRepository<Course, Long> {

    Course findByName(String name);

    //Course findById(Long id);

    Set<Course> findByUser(User user);

    Set<Course> findByAuthor_Id(Long id);
}
