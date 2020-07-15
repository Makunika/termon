package com.psh.termon.repos;


import com.psh.termon.data.Course;
import com.psh.termon.data.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface UserRep extends CrudRepository<User, Long> {
    //List<User> findByLogin(String login);
    User findByLogin(String login);
}
