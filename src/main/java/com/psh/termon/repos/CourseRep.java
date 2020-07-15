package com.psh.termon.repos;

import com.psh.termon.data.Course;
import com.psh.termon.data.User;
import org.springframework.data.repository.CrudRepository;


import java.util.Set;

public interface CourseRep extends CrudRepository<Course, Long> {
    Set<Course> findByAuthor_Id(Long id);
}
