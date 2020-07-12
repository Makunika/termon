package com.psh.termon.repos;


import com.psh.termon.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRep extends CrudRepository<User, Long> {
    //List<User> findByLogin(String login);
    User findByLogin(String login);
}
